# scrcpy-mask-server

scrcpy-mask-server 是在开源项目 scrcpy
基础上进行修改和扩展的一个分支项目，旨在更好地适应 [Scrcpy Mask](https://github.com/AkiChase/scrcpy-mask)
的功能，增强与设备交互的灵活性和实时性。

本人对其 scrcpy-server 部分进行了如下修改：

1. 移除了 `injectTouch` 和 `injectScroll` 中坐标相对视频帧尺寸的转换。
2. 在 control socket 连接成功后发送设备尺寸。
3. 在 control socket 中发送设备旋转通知。

## 声明

首先，我们要对 Scrcpy 项目的原始开发者表示深深的敬意和感谢。Scrcpy 是一个强大而高效的开源工具，极大地方便了
Android 设备的控制与显示。

Scrcpy Mask 的实现基于 Scrcpy 的优秀架构，进行了鼠标键盘控制的优化和调整。

Scrcpy 项目地址：[Genymobile/scrcpy](https://github.com/Genymobile/scrcpy)

## 修改详情

### 移除坐标转换

我们移除了 `injectTouch` 和 `injectScroll` 中坐标相对视频帧尺寸的转换逻辑。这一改动可以使得输入坐标直接对应设备的实际屏幕坐标。

### 发送设备尺寸

在 control socket 连接成功后，Scrcpy Mask 会立即发送设备的屏幕尺寸。这可以帮助客户端在初始化时获得设备的具体尺寸信息，从而进行更精准的交互处理。

### 设备旋转通知

Scrcpy Mask 增加了在设备旋转时，通过 control socket
发送旋转通知的功能。这样可以使客户端实时感知设备的旋转变化，及时调整显示和交互逻辑，提供更好的用户体验。

## 许可

Scrcpy Mask 遵循与 Scrcpy 相同的许可协议：Apache License 2.0。详情请参阅 [LICENSE](LICENSE) 文件。

## 鸣谢

再次感谢 Scrcpy 的开发团队和所有贡献者，感谢你们的付出和奉献使得这一项目成为可能。