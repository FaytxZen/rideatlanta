package com.andrewvora.apps.rideatlanta.data.models;

import android.content.Context;
import android.support.annotation.NonNull;

import com.andrewvora.apps.rideatlanta.R;
import com.andrewvora.apps.rideatlanta.data.contracts.FavoriteRouteDataObject;
import com.google.gson.annotations.SerializedName;

/**
 * Created by faytx on 10/23/2016.
 * @author Andrew Vorakrajangthiti
 */

public class Bus extends BaseModel implements FavoriteRouteDataObject {

    @SerializedName("ADHERENCE")
    private Integer adherence;

    @SerializedName("BLOCKID")
    private Integer blockId;

    @SerializedName("BLOCK_ABBR")
    private String blockAbbr;

    @SerializedName("DIRECTION")
    private String direction;

    @SerializedName("LATITUDE")
    private String latitude;

    @SerializedName("LONGITUDE")
    private String longitude;

    @SerializedName("MSGTIME")
    private String msgTime;

    @SerializedName("ROUTE")
    private String routeId;

    @SerializedName("STOPID")
    private Long stopId;

    @SerializedName("TIMEPOINT")
    private String timePoint;

    @SerializedName("TRIPID")
    private Long tripId;

    @SerializedName("VEHICLE")
    private Long vehicleNumber;

    private boolean favorited;

    public Integer getAdherence() {
        return adherence;
    }

    public void setAdherence(Integer adherence) {
        this.adherence = adherence;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public String getBlockAbbr() {
        return blockAbbr;
    }

    public void setBlockAbbr(String blockAbbr) {
        this.blockAbbr = blockAbbr;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public Long getStopId() {
        return stopId;
    }

    public void setStopId(Long stopId) {
        this.stopId = stopId;
    }

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Long getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(Long vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    @Override
    public String getFavoriteRouteKey() {
        return getName();
    }

    @Override
    public String getRouteId() {
        return routeId;
    }

    @Override
    public String getType() {
        return FavoriteRouteDataObject.TYPE_BUS;
    }

    @Override
    public String getName() {
        return getRouteId();
    }

    @Override
    public String getDestination() {
        return getTimePoint();
    }

    @Override
    public String getTimeTilArrival() {
        return String.valueOf(getAdherence());
    }

    public static int parseAdherence(String adherence) {
        int arrivalTime;

        try {
            arrivalTime = Integer.parseInt(adherence);
        }
        catch (Exception e) {
            arrivalTime = 0;
        }

        return arrivalTime;
    }

    public static String getFormattedAdherence(@NonNull Context context, int adherence) {
        final boolean isOnTime = adherence == 0;
        final boolean isEarly = adherence < 0;
        String status;

        if(adherence == Integer.MIN_VALUE) {
            status = context.getString(R.string.text_adherence_unknown);
        }
        else if(isOnTime) {
            status = context.getString(R.string.text_bus_adherence_suffix_on_time);
        }
        else if(isEarly) {
            status = String.format("%s %s",
                    Math.abs(adherence),
                    context.getString(R.string.text_bus_adherence_suffix_early));
        }
        else {
            status = String.format("%s %s",
                    adherence,
                    context.getString(R.string.text_bus_adherence_suffix_late));
        }

        return status;
    }
}
