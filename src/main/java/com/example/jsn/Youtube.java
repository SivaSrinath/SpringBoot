
package com.example.jsn;


public class Youtube {

    private String clickTrackingParams;
    private CommandMetadata commandMetadata;
    private LikeEndpoint likeEndpoint;

    public String getClickTrackingParams() {
        return clickTrackingParams;
    }

    public void setClickTrackingParams(String clickTrackingParams) {
        this.clickTrackingParams = clickTrackingParams;
    }

    public CommandMetadata getCommandMetadata() {
        return commandMetadata;
    }

    public void setCommandMetadata(CommandMetadata commandMetadata) {
        this.commandMetadata = commandMetadata;
    }

    public LikeEndpoint getLikeEndpoint() {
        return likeEndpoint;
    }

    public void setLikeEndpoint(LikeEndpoint likeEndpoint) {
        this.likeEndpoint = likeEndpoint;
    }

}
