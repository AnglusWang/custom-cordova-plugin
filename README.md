# custom-cordova-plugin
多功能 cordova 插件(Android版)

### 1. 插件的安装
开发工程下执行以下命令导入本插件：

	$ cordova plugin add <插件github地址>

已安装插件查看：

	$ cordova plugin ls


执行以下命令删本插件：

	$ cordova plugin rm custom-cordova-plugin

### 2. 插件功能简述

该插件有什么方法，都能做些什么事情 及其他

### 3. JS 调用方法说明

baidu_push.startWork

	baidu_push.startWork(api_key, cb_success);
	# api_key:百度云推送api_key
	# cb_success:调用成功回调方法，暂不考虑调用失败的回调，返回值结构如下：
	  #json: {
	    type: 'onbind', //对应Android Service的onBind方法
	    data: {
	      appId: 'xxxxxxxx',
	      userId: 'yyyyy',
	      channelId: 'zzzzzz'
	    }
	  }

baidu_push.stopWork

	baidu_push.startWork(cb_success);
	# cb_success:调用成功能回调方法，返回值结构如下：
	  #json: {
	    type: 'onunbind', //对应Android Service的onUnbind方法
	    errorCode: 'xxxxxx', //对应百度的请求错误码
	    data: {
	      requestId: 'yyyyyy', //对应百度的请求ID
	    }
	  }
