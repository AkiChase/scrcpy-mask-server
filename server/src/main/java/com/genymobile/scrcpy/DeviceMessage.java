package com.genymobile.scrcpy;

public final class DeviceMessage {

    public static final int TYPE_CLIPBOARD = 0;
    public static final int TYPE_ACK_CLIPBOARD = 1;
    public static final int TYPE_UHID_OUTPUT = 2;

    // scrcpy-mask: device rotation message
    public static final int TYPE_SM_ROTATION = 3;

    private int type;
    private String text;
    private long sequence;
    private int id;
    private byte[] data;

    private int rotation;
    private int width;
    private int height;

    private DeviceMessage() {
    }

    public static DeviceMessage createRotation(int rotation, Size size) {
        DeviceMessage event = new DeviceMessage();
        event.type = TYPE_SM_ROTATION;
        event.rotation = rotation;
        event.width = size.getWidth();
        event.height = size.getHeight();
        return event;
    }

    public static DeviceMessage createClipboard(String text) {
        DeviceMessage event = new DeviceMessage();
        event.type = TYPE_CLIPBOARD;
        event.text = text;
        return event;
    }

    public static DeviceMessage createAckClipboard(long sequence) {
        DeviceMessage event = new DeviceMessage();
        event.type = TYPE_ACK_CLIPBOARD;
        event.sequence = sequence;
        return event;
    }

    public static DeviceMessage createUhidOutput(int id, byte[] data) {
        DeviceMessage event = new DeviceMessage();
        event.type = TYPE_UHID_OUTPUT;
        event.id = id;
        event.data = data;
        return event;
    }

    public int getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public long getSequence() {
        return sequence;
    }

    public int getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }

    public int getRotation() {
        return rotation;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
