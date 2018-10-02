public class Reservation {

    public long pickupTime;
    public long returnTime;

    public Reservation(long pickupTime,long returnTime) {
        this.pickupTime = pickupTime;
        this.returnTime = returnTime;
    }

    public boolean overlaps(Reservation other) {
        if (this.pickupTime < other.getPickupTime()) {
            if (this.returnTime > other.getPickupTime()) {
                return true;
            }

        } else if (this.pickupTime > other.getPickupTime()) {
            if (this.pickupTime < other.getReturnTime()) {
                return true;
            }
        } else if (this.pickupTime == other.getPickupTime() || this.returnTime == other.getReturnTime()) {
            return true;

        }

        return false;

    }

    public long getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(long pickupTime) {
        this.pickupTime = pickupTime;
    }

    public long getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(long returnTime) {
        this.returnTime = returnTime;
    }
}
