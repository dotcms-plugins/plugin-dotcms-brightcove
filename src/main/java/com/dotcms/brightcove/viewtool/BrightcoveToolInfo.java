package com.dotcms.brightcove.viewtool;

import org.apache.velocity.tools.view.context.ViewContext;
import org.apache.velocity.tools.view.servlet.ServletToolInfo;

public class BrightcoveToolInfo extends ServletToolInfo {

    @Override
    public String getKey () {
        return "brightcove";
    }

    @Override
    public String getScope () {
        return ViewContext.APPLICATION;
    }

    @Override
    public String getClassname () {
        return BrightcoveTool.class.getName();
    }

    @Override
    public Object getInstance ( Object initData ) {

    	BrightcoveTool viewTool = new BrightcoveTool();
        viewTool.init( initData );

        return viewTool;
    }

}