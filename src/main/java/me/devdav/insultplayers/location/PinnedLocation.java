package me.devdav.insultplayers.location;

import org.bukkit.Location;

public class PinnedLocation {
    public String messageEnter;
    public String messageLeave;
    public Corner topLeft;
    public Corner topRight;
    public Corner bottomRight;
    public Corner bottomLeft;
    public Corner[] corners;

    public PinnedLocation(String messageEnter,
                          String messageLeave,
                          Corner cTopLeft,
                          Corner cTopRight,
                          Corner cBottomRight,
                          Corner cBottomLeft) {
        this.messageEnter = messageEnter;
        this.messageLeave = messageLeave;
        this.topLeft = cTopLeft;
        this.topRight = cTopRight;
        this.bottomRight = cBottomRight;
        this.bottomLeft = cBottomLeft;
        corners = new Corner[]{topLeft, topRight, bottomRight, bottomLeft};
    }

    /**
     * @param messageEnter
     * @param messageLeave
     * @param corners      must be given in this order top left, top right, bottom right, bottom left
     */
    public PinnedLocation(String messageEnter,
                          String messageLeave,
                          Corner[] corners) {
        this.messageEnter = messageEnter;
        this.messageLeave = messageLeave;
        this.corners = corners;
        this.topLeft = corners[0];
        this.topRight = corners[1];
        this.bottomRight = corners[2];
        this.bottomLeft = corners[3];
    }

    public boolean hasInside(Location minecraftLocation) {
        int x = minecraftLocation.getBlockX();
        int z = minecraftLocation.getBlockZ();

        boolean isInHorizontally =
                (x >= topLeft.x && x <= topRight.x)
                && (x >= bottomLeft.x && x <= bottomRight.x);

        boolean isInVertically =
                (z >= bottomLeft.z && z <= topLeft.z)
                && (z >= bottomRight.z && z <= topRight.z);

        return isInHorizontally && isInVertically;
    }
}


