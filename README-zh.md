# scrcpy-mask-server

scrcpy-mask-server 是在开源项目 scrcpy 基础上进行修改和扩展的一个分支项目，旨在更好地适应 [Scrcpy Mask](https://github.com/AkiChase/scrcpy-mask) 的功能，增强与设备交互的灵活性和实时性。

当前仓库以 scrcpy server `v4.0` 源码作为上游基线，并在其上保留以下改动：

1. control 通道里的指针坐标按物理显示坐标处理，不按视频帧坐标处理。
2. control 启用时，通过 control socket 发送显示尺寸和旋转。
3. 显示旋转或尺寸变化时，通过 control socket 发送通知。

这些改动是 Scrcpy Mask 的协议需求：Scrcpy Mask 可能不启用视频连接，此时客户端不知道视频帧尺寸，因此 control 消息中的 `Position.screenSize` 会被有意解释为从 control 通道收到的设备/显示尺寸。

## 声明

首先，我们要对 Scrcpy 项目的原始开发者表示深深的敬意和感谢。Scrcpy 是一个强大而高效的开源工具，极大地方便了
Android 设备的控制与显示。

Scrcpy Mask 的实现基于 Scrcpy 的优秀架构，进行了鼠标键盘控制的优化和调整。

Scrcpy 项目地址：[Genymobile/scrcpy](https://github.com/Genymobile/scrcpy)

## 修改详情

### control 坐标

scrcpy v4.0 默认会把指针事件从视频帧坐标映射到设备/显示坐标。Scrcpy Mask 在 control 消息中绕过这层映射：`injectTouch` 和 `injectScroll` 会直接把 `Position.point` 当作物理显示坐标使用。

### 发送显示尺寸

当 control 对真实显示启用时，server 会通过 control socket 发送当前显示的宽、高和旋转。这样即使视频关闭，客户端也能初始化指针缩放。

### 设备旋转通知

Scrcpy Mask 增加了在显示旋转或尺寸变化时，通过 control socket 发送显示属性通知的功能。这样可以使客户端实时感知变化，及时调整显示和交互逻辑。

## 构建

```sh
bash build-server.sh
```

构建产物为 `./scrcpy-mask-server-v4.0`。

## 许可

Scrcpy Mask 遵循与 Scrcpy 相同的许可协议：Apache License 2.0。详情请参阅 [LICENSE](LICENSE) 文件。

## 鸣谢

再次感谢 Scrcpy 的开发团队和所有贡献者，感谢你们的付出和奉献使得这一项目成为可能。
