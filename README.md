# miniprogram-steam

> 前端项目地址：https://github.com/SlowStepFestival/GameAssistant


### 获取游戏
接口地址：http://47.103.206.26:8080/miniprogram/list/games
请求方法：GET

request：
  - gameId（可选），通过游戏 Id 查询游戏列表
  - name（可选），通过游戏 name 查询游戏列表，支持模糊查询%name%
  
response：
gameList：游戏列表
  - gameId，游戏 Id
  - name，游戏名字
  - price，游戏当前价格
  - oldprice，游戏历史价格
  - discount，游戏折扣（百分制，如 70 = 70%OFF）
  - score，游戏评分
  - priority，游戏热度（人数）
  - imageUrl，游戏图片
  - logoUrl，logo 图片
  - introduction，游戏简介
  - tag，游戏标签
  - releaseDate，发售日期
  msg：日志信息
  
调用例子：
http://47.103.206.26:8080/miniprogram/list/games 获取所有游戏列表
http://47.103.206.26:8080/miniprogram/list/games?gameId=1 获取游戏 Id 为 1 的游戏

### 获取热门游戏
接口地址：http://47.103.206.26:8080/miniprogram/list/hot/games
请求方法：GET

request：
  - limit（可选），查询数量
  
response：
  - gameList：游戏列表
  - msg：日志信息
  
调用例子：
http://47.103.206.26:8080/miniprogram/list/hot/games？limit=10 获取前十热门游戏

### 获取最大折扣游戏
接口地址：http://47.103.206.26:8080/miniprogram/list/specials/games
请求方法：GET

request：
  - limit（可选），查询数量

response：
  - gameList：游戏列表
  - msg：日志信息

### 获取最新发售游戏
接口地址：http://47.103.206.26:8080/miniprogram/list/release/games
请求方法：GET

request：
  - limit（可选），查询数量

response：
  - gameList：游戏列表
  - msg：日志信息

### 获取成就
接口地址：http://47.103.206.26:8080/miniprogram/list/achievements
请求方法：GET

request：
  - gameId（必选）,通过游戏 Id 查询成就列表

response：
List<Achievement>：成就列表
  - achievementId，成就 Id
  - achievementName，成就名字
  - imageUrl，成就图片
  - profile，成就详情
  - getPercent，成就完成度（百分制，如 80 = 80%achieve）
  - name，成就所属游戏名字
msg：日志信息

调用例子：
http://47.103.206.26:8080/miniprogram/list/achievements?gameId=1 查询游戏 Id 为 1 的成就列表

### 注册用户（待定）
接口地址：http://47.103.206.26:8080/miniprogram/info/register
请求方法：POST

request：
  - username（必选），用户名
  - password（必选），密码

response：
  - success，是否注册成功
  - msg，日志信息

### 用户登陆（待定）
接口地址：http://47.103.206.26:8080/miniprogram/info/login
请求方法：POST

request：
  - username（必选），用户名
  - password（必选），密码

response：
  - success，是否登陆成功
  - msg，日志信息
  
  
# 注：在右上角详情-本地设置，把不校验 HTTPS 证书钩上。
