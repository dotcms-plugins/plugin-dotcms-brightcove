package com.dotcms.brightcove.model;

import java.util.Arrays;
import java.util.Date;

import com.dotcms.repackage.com.google.gson.Gson;

public class BrightcoveVideo {

	long id;
	String name;
	String adKeys;
	String shortDescription;
	String LongDescription;
	long creationDate;
	long publishDate;
	long lastModifiedDate;
	String linkUrl;
	String linkText;
	String[] tags;
	String referenceId;
	String videoStillURL;
	String thumbnailURL;
	long length;
	String economics;
	int plays;
	int playsTrailingWeek;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdKeys() {
		return adKeys;
	}

	public void setAdKeys(String adKeys) {
		this.adKeys = adKeys;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return LongDescription;
	}

	public void setLongDescription(String longDescription) {
		LongDescription = longDescription;
	}


	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}

	public long getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(long publishDate) {
		this.publishDate = publishDate;
	}

	public long getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(long lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}



	public String getVideoStillURL() {
		return videoStillURL;
	}

	public void setVideoStillURL(String videoStillURL) {
		this.videoStillURL = videoStillURL;
	}

	public String getThumbnailURL() {
		return thumbnailURL;
	}

	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public String getEconomics() {
		return economics;
	}

	public void setEconomics(String economics) {
		this.economics = economics;
	}

	public int getPlays() {
		return plays;
	}

	public void setPlays(int plays) {
		this.plays = plays;
	}

	public int getPlaysTrailingWeek() {
		return playsTrailingWeek;
	}

	public void setPlaysTrailingWeek(int playsTrailingWeek) {
		this.playsTrailingWeek = playsTrailingWeek;
	}

	
	public Date getCreateDate(){
		Date d = new Date(this.creationDate);
		return d;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);

	}
	
}
