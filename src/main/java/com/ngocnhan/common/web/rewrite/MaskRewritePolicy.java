package com.ngocnhan.common.web.rewrite;

import com.ngocnhan.common.web.util.ListUtil;
import com.ngocnhan.common.web.util.StringUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rewrite.RewritePolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.status.StatusLogger;

@RequiredArgsConstructor
@Plugin(name = "MaskRewritePolicy", category = Core.CATEGORY_NAME, elementType = "rewritePolicy", printObject = true)
public final class MaskRewritePolicy implements RewritePolicy {

  private static final Logger LOGGER = StatusLogger.getLogger();

  private final char maskCharacter;
  private final Pattern maskPattern;

  @Override
  public LogEvent rewrite(final LogEvent source) {
    StringBuilder message = new StringBuilder(source.getMessage().getFormattedMessage());
    Matcher matcher = maskPattern.matcher(message);
    while (matcher.find()) {
      IntStream.rangeClosed(1, matcher.groupCount())
          .filter(group -> matcher.group(group) != null)
          .forEach(group -> IntStream.range(matcher.start(group), matcher.end(group))
              .forEach(i -> message.setCharAt(i, maskCharacter)));
    }

    SimpleMessage simpleMessage = new SimpleMessage(message.toString());
    return new Log4jLogEvent.Builder(source)
        .setMessage(simpleMessage)
        .build();
  }

  @PluginFactory
  public static MaskRewritePolicy createMaskRewritePolicy(
      @PluginAttribute("MaskCharacter") final char maskCharacter,
      @PluginElement("MaskPattern") final MaskPattern[] maskPatterns) {

    try {
      String regex = ListUtil.emptyIfNull(maskPatterns)
          .stream()
          .map(MaskPattern::getField)
          .filter(StringUtil::isNotBlank)
          .collect(Collectors.joining("|"));
      Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

      return new MaskRewritePolicy(maskCharacter, pattern);
    } catch (IllegalArgumentException e) {
      LOGGER.error("Pattern is not correct");
      return null;
    }
  }

}