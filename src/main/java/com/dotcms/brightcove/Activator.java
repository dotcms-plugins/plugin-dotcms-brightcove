package com.dotcms.brightcove;


import com.dotcms.brightcove.viewtool.BrightcoveToolInfo;
import com.dotcms.repackage.org.osgi.framework.BundleContext;
import com.dotmarketing.osgi.GenericBundleActivator;
import com.dotmarketing.util.Logger;



public class Activator extends GenericBundleActivator {


	public void start(BundleContext bundleContext) throws Exception {
        //Initializing services...
        initializeServices( bundleContext );

        //Registering the ViewTool service
        registerViewToolService( bundleContext, new BrightcoveToolInfo() );


		
		Logger.info(this.getClass(), "Starting Brightcove Viewtool - $brightcove");

	}

	public void stop(BundleContext context) throws Exception {

		unregisterViewToolServices();
		Logger.info(this.getClass(), "Stopping Brightcove Viewtool - $useragent");


	}

}