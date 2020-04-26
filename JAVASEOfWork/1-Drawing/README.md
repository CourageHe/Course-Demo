# Eclipse配置WindowBuilder

## WindowBuilder插件介绍

​	在做窗体程序的开发中，传统的Java语言在开发窗体应用程序中仅靠代码语句来实现对控件的控制显得不够灵活和准确，难以高效的开发具有良好用户界面的应用程序，所以我们应该寻找Java中可以拖拽控件来实现窗体绘制的插件。所幸的是找到了一种还算好用的插件——WindowBuilder，它是一款基于Eclipse平台的双向Java的GUI设计插件式的软件，它具备SWT/JFACE开发、Swing开发及GWT开发三大功能，是一款不可多得的Java体系中的WYSIWYG工具。

## 曲折的配置之路

​	起初并不打算写这篇配置文章，以为网上一搜一大把WindowBuilder的配置文章。然而现实是残酷的，由于eclipse部分官网的变更导致CSDN上绝大多数的配置参考失去价值，一个**深坑**！！！由于eclipse的官网在国内访问极不稳定，Eclipse下载软件速度很慢，漫长的等待过程，然后便是不断尝试不断失败！！！

​	进入 **Help**—>**Eclipse Marketplace** ，搜索 **WindowBuilder**,

搜索结果如下：

![](../images/3-windowbuilder配置-eclipseMarket.png)



​	点击 **install**然后等待一会，持续下一步即可。最好将eclipse更新为最新版本，以便出现不必要的错误！！！

根据提示重启之后，新建项目->其他->WindowBuilder,如下图即配置成功！！！

![](../images/3-windowbuilder配置-新建检验.png)

## 开启HelloWorld之路

​	尚未完成所有功能，只是搭了一个基础的架子。革命还需努力！！！

![](../images/测试.png)

