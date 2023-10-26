# Tryjoin
bc端子服关闭自动回到login服务器

1. 将插件放到bungee插件文件夹中，启动服务器。
2. 插件会拦截服务器踢出玩家的事件，并将服务器链接到login服务器。


> 修改服务器名称，请编辑Tryjoin.java中的onServerKick方法，修改login字符串，并重新编译。
