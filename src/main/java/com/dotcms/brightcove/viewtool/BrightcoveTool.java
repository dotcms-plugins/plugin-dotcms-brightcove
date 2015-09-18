package com.dotcms.brightcove.viewtool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.velocity.tools.view.tools.ViewTool;

import com.dotcms.brightcove.BrightcovePluginProperties;
import com.dotcms.brightcove.model.BrightcoveVideo;
import com.dotcms.repackage.com.google.common.cache.Cache;
import com.dotcms.repackage.com.google.common.cache.CacheBuilder;
import com.dotcms.repackage.com.google.common.cache.CacheLoader;
import com.dotcms.repackage.com.google.gson.Gson;
import com.dotmarketing.util.UtilMethods;
import com.dotmarketing.util.json.JSONArray;
import com.dotmarketing.util.json.JSONException;
import com.dotmarketing.util.json.JSONObject;
import com.dotmarketing.viewtools.JSONTool;

public class BrightcoveTool implements ViewTool {


	Cache<String, String> cache;

	public void init(Object obj) {
		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			@Override
			public String load(String key) {
				return key.toUpperCase();
			}
		};

		cache = CacheBuilder.newBuilder().maximumSize(1000).weakKeys().expireAfterWrite(60, TimeUnit.SECONDS).build(loader);


	}

	/**
	 * gets all brightcove videos
	 * 
	 * @param url
	 * @param user
	 * @param pass
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public List<BrightcoveVideo> getAll() throws Exception {

		
		JSONObject json = read(null);
		JSONArray arr =  json.getJSONArray("items");
		arr.length();
		JSONObject[] vids = new JSONObject[arr.length()]; 
		
		List<BrightcoveVideo> videos = new ArrayList<BrightcoveVideo>();
		vids = arr.toArray(vids);
		for(JSONObject vid : vids){


			videos.add(fromJson(vid));
		}
		
		
		return videos;

	}
	
	/**
	 * Takes an id and returns the Brightcove Video Object
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BrightcoveVideo find(String id) throws Exception {

		
		JSONObject json = read(null);
		JSONArray items =  json.getJSONArray("items");

		JSONObject[] vids = new JSONObject[ items.length()]; 

		vids = items.toArray(vids);
		for(JSONObject vid : vids){


			BrightcoveVideo bcv =fromJson(vid);
			if(id.equals(String.valueOf(bcv.getId()))){
				return  bcv;
			}
		}
		
		
		return null;

	}
	
	private BrightcoveVideo fromJson(JSONObject json) throws JSONException{


		Gson gson = new Gson();
		BrightcoveVideo bcv = gson.fromJson(json.toString(), BrightcoveVideo.class);
		bcv.setThumbnailURL(json.getString("thumbnailURL"));
		bcv.setVideoStillURL(json.getString("videoStillURL"));
		return bcv;
	}
	
	
	public String toJson() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(getAll());

	}
	long refresh=0;
	static JSONObject jsonCache=null;
	private JSONObject read(String search) throws Exception {
		
		if(refresh < System.currentTimeMillis()-60*1000){
			jsonCache=null;
			refresh = System.currentTimeMillis();
		}
		if(jsonCache==null){
			
			if(UtilMethods.isSet(search)){
				return null;
			}
			else{
				jsonCache= new JSONTool().fetch("http://api.brightcove.com/services/library?command=find_all_videos&token=" + BrightcovePluginProperties.getProperty("BRIGHTCOVE_API_KEY"));
			}
		}
		return jsonCache;
	}


}
