# 自定义Cordova Plugin

## 创建插件流程
### 安装 plugman
`npm install -g plugman`

### 创建plugin
`plugman create --name SimplePlugin --plugin_id com.skytech.simpleplugin --plugin_version 0.0.1`

### 添加android平台代码

`plugman platform add --platform_name android `

### 创建package.json文件
`cd SimplePlugin`
`npm init`

> 配置参数随意填

### 安装本插件
`cordova plugin add /Users/zhouxiaolong/DevelopmentCode/hybird_2019/SimplePlugin`

>注：此处插件路径为文件路径

## Android原生代码书写
### 建议在Android Studio中书写
    生成Cordova项目，add Android platform，用Android Studio打开android文件夹，编写Android代码

## 外部使用

创建Cordova 项目

```
<button id="new_activity">New Activity</button>
```

```
document.getElementById("new_activity").addEventListener("click", new_activity);

function new_activity() {
    console.log("----start------");
    cordova.plugins.SimplePlugin.startNewActivity(function (success) {
        alert(success)
    }, function (error) {
        alert(error)
    });
}
```

