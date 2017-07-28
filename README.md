# TinkerDemo
### Tinker介绍
Tinker是微信团队开源的Android热修复工具，支持dex, library和resources的热更新。关于Tinker的基本的接入方法、Api和原理等，在官方wiki中有非常详细的介绍。我这里重点描述一下基于我们项目的接入流程（客户端和后台），使用姿势和遇到的问题，以及如何在Jenkins上构建补丁包。
#### 集成微信Tinker, 热补丁及时修复问题
使用TinkerPatch，一键集成，TinkerPatch 平台帮你做了这些工作，提供了补丁后台托管，版本管理，保证传输安全等功能，让你无需搭建一个后台，无需关心部署操作，只需引入一个 SDK 即可立即使用 Tinker。
#### 根据基准包生成的补丁后，在TinkerPatch后台发布，默认三小时检测一次。
