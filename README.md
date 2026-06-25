# scrcpy-mask-server

[中文说明](README-zh.md)

scrcpy-mask-server is a fork project based on the open-source project scrcpy, aiming to better adapt to the functionality of [Scrcpy Mask](https://github.com/AkiChase/scrcpy-mask) by enhancing flexibility and real-time interaction with devices.

This repository currently uses the scrcpy server `v4.0` source as its upstream baseline. The following modifications are applied on top of it:

1. Control-channel pointer coordinates are treated as physical display coordinates, not video-frame coordinates.
2. The server sends display dimensions and rotation through the control socket when control is enabled.
3. Display rotation/size changes are reported through the control socket.

These changes are required because Scrcpy Mask may run without a video connection. In that mode, the client does not know the video frame size, so `Position.screenSize` in control messages is intentionally interpreted as the device/display size received from the control channel.

## Disclaimer

First and foremost, we would like to express our deep respect and gratitude to the original developers of the Scrcpy project. Scrcpy is a powerful and efficient open-source tool that greatly facilitates the control and display of Android devices.

The implementation of Scrcpy Mask is based on the excellent architecture of Scrcpy, with optimizations and adjustments made for mouse and keyboard control.

Scrcpy project repository: [Genymobile/scrcpy](https://github.com/Genymobile/scrcpy)

## Modification Details

### Control Coordinates

scrcpy v4.0 normally maps pointer events from video-frame coordinates to device/display coordinates. Scrcpy Mask bypasses that mapping for control messages: `injectTouch` and `injectScroll` use the raw `Position.point` as a physical display coordinate.

### Display Dimensions

When control is enabled for a real display, the server sends the current display width, height, and rotation over the control socket. This lets the client initialize pointer scaling even when video is disabled.

### Device Rotation Notification

Scrcpy Mask adds the functionality to send display property notifications through the control socket when the display rotates or its size changes. This allows the client to adjust display and interaction logic promptly.

## Build

```sh
bash build-server.sh
```

The build output is `./scrcpy-mask-server-v4.0`.

## License

Scrcpy Mask follows the same license agreement as Scrcpy: Apache License 2.0. For details, please refer to the [LICENSE](LICENSE) file.

## Acknowledgments

Once again, we would like to thank the development team of Scrcpy and all contributors for their dedication and contribution, making this project possible.
