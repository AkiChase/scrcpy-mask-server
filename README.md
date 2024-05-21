# scrcpy-mask-server

[中文说明](README-zh.md)

scrcpy-mask-server is a fork project based on the open-source project scrcpy, aiming to better adapt to the functionality of [Scrcpy Mask](https://github.com/AkiChase/scrcpy-mask) by enhancing flexibility and real-time interaction with devices.

The following modifications have been made to the scrcpy-server part:

1. Removal of coordinate transformations relative to the video frame size in `injectTouch` and `injectScroll`.
2. Sending device dimensions after successful control socket connection.
3. Sending device rotation notifications through the control socket.

## Disclaimer

First and foremost, we would like to express our deep respect and gratitude to the original developers of the Scrcpy project. Scrcpy is a powerful and efficient open-source tool that greatly facilitates the control and display of Android devices.

The implementation of Scrcpy Mask is based on the excellent architecture of Scrcpy, with optimizations and adjustments made for mouse and keyboard control.

Scrcpy project repository: [Genymobile/scrcpy](https://github.com/Genymobile/scrcpy)

## Modification Details

### Removal of Coordinate Transformation

We removed the logic of coordinate transformations relative to the video frame size in `injectTouch` and `injectScroll`. This change allows input coordinates to directly correspond to the actual screen coordinates of the device.

### Sending Device Dimensions

After the control socket connection is successful, Scrcpy Mask immediately sends the screen dimensions of the device. This helps the client to obtain specific device dimensions during initialization for more precise interaction handling.

### Device Rotation Notification

Scrcpy Mask adds the functionality to send rotation notifications through the control socket when the device rotates. This allows the client to perceive device rotation changes in real-time and adjust display and interaction logic promptly, providing a better user experience.

## License

Scrcpy Mask follows the same license agreement as Scrcpy: Apache License 2.0. For details, please refer to the [LICENSE](LICENSE) file.

## Acknowledgments

Once again, we would like to thank the development team of Scrcpy and all contributors for their dedication and contribution, making this project possible.