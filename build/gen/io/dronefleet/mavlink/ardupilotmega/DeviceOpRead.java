package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Read registers for a device 
 */
@MavlinkMessage(
    id = 11000,
    crc = 134
)
public final class DeviceOpRead {
  private final int targetSystem;

  private final int targetComponent;

  private final long requestId;

  private final DeviceOpBustype bustype;

  private final int bus;

  private final int address;

  private final List<Integer> busname;

  private final int regstart;

  private final int count;

  private DeviceOpRead(int targetSystem, int targetComponent, long requestId,
      DeviceOpBustype bustype, int bus, int address, List<Integer> busname, int regstart,
      int count) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.requestId = requestId;
    this.bustype = bustype;
    this.bus = bus;
    this.address = address;
    this.busname = busname;
    this.regstart = regstart;
    this.count = count;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * request ID - copied to reply 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final long requestId() {
    return requestId;
  }

  /**
   * The bus type 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final DeviceOpBustype bustype() {
    return bustype;
  }

  /**
   * Bus number 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int bus() {
    return bus;
  }

  /**
   * Bus address 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int address() {
    return address;
  }

  /**
   * Name of device on bus (for SPI) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1,
      arraySize = 40
  )
  public final List<Integer> busname() {
    return busname;
  }

  /**
   * First register to read 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1
  )
  public final int regstart() {
    return regstart;
  }

  /**
   * count of registers to read 
   */
  @MavlinkMessageField(
      position = 9,
      length = 1
  )
  public final int count() {
    return count;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private long requestId;

    private DeviceOpBustype bustype;

    private int bus;

    private int address;

    private List<Integer> busname;

    private int regstart;

    private int count;

    private Builder() {
    }

    /**
     * System ID 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Component ID 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * request ID - copied to reply 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder requestId(long requestId) {
      this.requestId = requestId;
      return this;
    }

    /**
     * The bus type 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder bustype(DeviceOpBustype bustype) {
      this.bustype = bustype;
      return this;
    }

    /**
     * Bus number 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder bus(int bus) {
      this.bus = bus;
      return this;
    }

    /**
     * Bus address 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder address(int address) {
      this.address = address;
      return this;
    }

    /**
     * Name of device on bus (for SPI) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1,
        arraySize = 40
    )
    public final Builder busname(List<Integer> busname) {
      this.busname = busname;
      return this;
    }

    /**
     * First register to read 
     */
    @MavlinkMessageField(
        position = 8,
        length = 1
    )
    public final Builder regstart(int regstart) {
      this.regstart = regstart;
      return this;
    }

    /**
     * count of registers to read 
     */
    @MavlinkMessageField(
        position = 9,
        length = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    public final DeviceOpRead build() {
      return new DeviceOpRead(targetSystem, targetComponent, requestId, bustype, bus, address, busname, regstart, count);
    }
  }
}