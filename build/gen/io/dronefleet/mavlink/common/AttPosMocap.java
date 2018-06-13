package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * Motion capture attitude and position 
 */
@MavlinkMessage(
    id = 138,
    crc = 109
)
public final class AttPosMocap {
  private final BigInteger timeUsec;

  private final List<Float> q;

  private final float x;

  private final float y;

  private final float z;

  private final List<Float> covariance;

  private AttPosMocap(BigInteger timeUsec, List<Float> q, float x, float y, float z,
      List<Float> covariance) {
    this.timeUsec = timeUsec;
    this.q = q;
    this.x = x;
    this.y = y;
    this.z = z;
    this.covariance = covariance;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4,
      arraySize = 4
  )
  public final List<Float> q() {
    return q;
  }

  /**
   * X position in meters (NED) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float x() {
    return x;
  }

  /**
   * Y position in meters (NED) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float y() {
    return y;
  }

  /**
   * Z position in meters (NED) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float z() {
    return z;
  }

  /**
   * Pose covariance matrix upper right triangular (first six entries are the first ROW, next five 
   * entries are the second ROW, etc.) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4,
      arraySize = 21,
      extension = true
  )
  public final List<Float> covariance() {
    return covariance;
  }

  public class Builder {
    private BigInteger timeUsec;

    private List<Float> q;

    private float x;

    private float y;

    private float z;

    private List<Float> covariance;

    private Builder() {
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4,
        arraySize = 4
    )
    public final Builder q(List<Float> q) {
      this.q = q;
      return this;
    }

    /**
     * X position in meters (NED) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder x(float x) {
      this.x = x;
      return this;
    }

    /**
     * Y position in meters (NED) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder y(float y) {
      this.y = y;
      return this;
    }

    /**
     * Z position in meters (NED) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    /**
     * Pose covariance matrix upper right triangular (first six entries are the first ROW, next five 
     * entries are the second ROW, etc.) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4,
        arraySize = 21,
        extension = true
    )
    public final Builder covariance(List<Float> covariance) {
      this.covariance = covariance;
      return this;
    }

    public final AttPosMocap build() {
      return new AttPosMocap(timeUsec, q, x, y, z, covariance);
    }
  }
}