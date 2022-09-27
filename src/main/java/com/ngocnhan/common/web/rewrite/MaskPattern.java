package com.ngocnhan.common.web.rewrite;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.config.plugins.PluginValue;

@Getter
@RequiredArgsConstructor
@Plugin(name = "MaskPattern", category = Node.CATEGORY, printObject = true)
public final class MaskPattern {

  private final String field;

  @PluginFactory
  public static MaskPattern createBlacklistProperty(
      @PluginValue("field") final String field) {

    return new MaskPattern(field);
  }

}