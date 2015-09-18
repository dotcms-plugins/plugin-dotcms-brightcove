# Brightcove example plugin

## Description
This viewtool calls a remote web service at brightcove and returns a list of videos back to the user

## Usage
```
viewtool: $brightcove

## get all videos
#foreach($vid in $brightcove.all)
  $vid.id : $vid.name
#end

## get one video
$brightcove.find("$contentlet.brightcoveVideo")

```
