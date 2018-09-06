**2018/09/05**

jsp无法编译到target中，也无法打包成war包，试了idea的build，compile，但是无论怎么都无法成功，新建了web项目
运行良好，但是在这个项目中就是始终都无法编译和打包，无论怎么修改配置，对于菜鸟来说，遇到一些非代码问题就只能
瞎猫碰上死耗子了。

后来终于发现时因为maven的编译，打包的方式不对，这源于对idea的compile，build，make的具体功能是什么不是很了解
后来问了同事，才发现时是自己的maven的使用不对导致这么麻烦。
maven 个人认为比较好的入门基础教学：https://www.cnblogs.com/sunddenly/p/4341542.html
