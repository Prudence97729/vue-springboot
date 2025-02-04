## 12.26

### idea激活：

idea保存到了D盘，idea2024是安装包所在位置，idea_2024是idea所在的位置；

参考的B站视频，在idea激活收藏夹里。

### 创建springboot项目

==创建module的时候勾选spirngboot，可以快速完成创建==

创建新文件的时候没有java类，原因是没有构建好工程，先运行一下，然后发生了构建错误

构建项目的时候gradle报错，原因是Gradle JVM 没有选择17，而是默认的1.8，修改应用后成功解决。

![image-20241226105857148](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241226105857148.png)

运行时，8080端口无法返回hello，原因是少写了@RestController

![image-20241226110639220](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241226110639220.png)



学学 linux脚本 和 git 和 sql



### git命令操作

在仓库可以拉取项目到本地，新建一个文件夹，右键git bash，git pull 可以拉取项目

![image-20241226202816313](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241226202816313.png)

#### 步骤

git init //把文件夹初始化为git能管理的文件夹(你第一次上传普通文件的时候有用)

git clone https://github.com/Prudence97729/homework1.git //根据url把项目克隆到本地仓库 （附带git配置操作）

git clone git@github.com:Prudence97729/homework1.git //根据ssh克隆

密钥文件：C:\Users\HP.LAPTOP-JUSOBNLA\.ssh\id_rsa.pub

![image-20241226211155768](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241226211155768.png)

git pull 拉取项目

git status 是指查看更新的文件

git add . 是指添加所有更新的信息

git commit -m "输入提交日志"  //日志提交

git push -u origin main 提交到远端仓库(这个main是指分支名)

![image-20241226203550365](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241226203550365.png)



## 12.27

### springboot访问流程

![image-20241227105501781](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227105501781.png)

![image-20241227105526151](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227105526151.png)

### 新建一个web springboot 项目（有几种方法）

使用spring Boot 快速创建（但需要联网，访问外网可能受影响），也可以直接访问spring官网去快速创建。

![image-20241227184320961](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227184320961.png)

![image-20241227184252717](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227184252717.png)

刚创建后是这样的java文件夹是灰色的，正确的应为蓝色

![image-20241227184546309](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227184546309.png)

又重新试了一下，就好了

![image-20241227184920357](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227184920357.png)

发现了问题，当文件是灰色的时候，表明maven未构建，只需右键pom.xml，最下方添加为maven项目即可

![image-20241227190028672](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227190028672.png)

启动好之后，直接运行ZsqApplication即可，springboot已经初始化配置好了，tomcat等，不过springboot要联网，访问外网的速度可能影响构建速度

![image-20241227190811448](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227190811448.png)

![image-20241227191629093](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227191629093.png)

第二种创建方式（访问spirng官网）

![image-20241227192338589](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227192338589.png)



![image-20241227192358930](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227192358930.png)

第三种创建方式，用阿里云

![image-20241227192629910](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227192629910.png)

第四种方式，手动

在pom文件里配置，参考之前的pom文件，需要添加parent，dependence

![image-20241227192943498](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227192943498.png)

手动添加main

![image-20241227193057339](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227193057339.png)

右侧可以刷新maven项目

![image-20241227193129939](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227193129939.png)

小技巧，隐藏不想看到的文件

![image-20241227193652295](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227193652295.png)

引导类：用于启动程序，初始化Spring容器

![image-20241227195204223](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227195204223.png)

### Rest风格

![image-20241227202425576](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227202425576.png)

![image-20241227202435348](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227202435348.png)

简化版：

![image-20241227203121119](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227203121119.png)

![image-20241227203239114](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227203239114.png)

### springboot 整合mybatis

![image-20241227205804453](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227205804453.png)

![image-20241227205825710](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227205825710.png)

把resources文件类型改成yml，在里面输入datas配置数据库

![image-20241227210115898](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227210115898.png)

![image-20241227205903396](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227205903396.png)

![image-20241227205952270](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227205952270.png)

![image-20241227210221591](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227210221591.png)

![image-20241227210240677](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227210240677.png)

## 12.27 springboot3 + vue3



![image-20241227212118287](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227212118287.png)

#### ![image-20241227214025076](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227214025076.png) 1.在idea中建立数据库表

![image-20241227215003224](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227215003224.png)

#### 2.执行sql文件建立数据库

根据资源里的sql文件，用记事本方式打开，复制，全选后，运行

![image-20241227215129053](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227215129053.png)

#### 3.创建项目

注意这里有个小坑，创建的时候软件包默认的太长了，可以修改一下

![image-20241227221520263](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227221520263.png)

也就是这个软件包名称，修改为com.zsq即可

![image-20241227221625685](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227221625685.png)

但会出现问题：创建的软件包没有分层，只需要在“项目”旁边的外观中去掉“压缩空的中间包即可”

![image-20241228104648671](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228104648671.png)

用快速创建方式创建项目，导入三个依赖包

![image-20241227220249647](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227220249647.png)

#### 4.配置yml文件

把resources里面的properties文件改成yml格式，然后配置

![image-20241227220429283](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227220429283.png)

如下配置

![image-20241227220712863](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241227220712863.png)

#### 5.创建一些文件夹

![image-20241228105106215](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228105106215.png)

#### 6.导入文件

![image-20241228105223900](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228105223900.png)

导入到pojo实体类文件夹

![image-20241228105322092](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228105322092.png)

#### 7.启动类（springboot快速创建已经写好，包括依赖等）

![image-20241228105526977](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228105526977.png)

## 12.28

### 上传到github

从远程仓库clone下来后会在idea_project多出来一个远程仓库的文件夹，在idea_projectclone后需要再在这个vue-springboot路径下操作

![image-20241228113503229](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228113503229.png)

![image-20241228114204711](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228114204711.png)

### 开发注册接口

#### 1.用lombook工具添加getter setter等方法

![image-20241228110115402](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228110115402.png)

![image-20241228110329130](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228110329130.png)

添加好之后别忘记刷新maven

![image-20241228110350011](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228110350011.png)

在类名上面添加@Data即可

![image-20241228114750493](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228114750493.png)

#### 2.添加result类用于返回响应信息

![image-20241228115205257](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228115205257.png)

加上两个注解@

![image-20241228115402102](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228115402102.png)

泛型

![image-20241228115805004](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228115805004.png)



#### 3.三层框架controller service  mapper

##### controller service mapper 书写

![image-20241228120224199](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228120224199.png)

创建接口，并让java类实现接口

![image-20241228120902185](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228120902185.png)

创建mapper接口

![image-20241228121025224](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228121025224.png)



刚开始找不到@RestController，是依赖的问题，导入即可

![image-20241228121725822](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228121725822.png)

编辑启动器，添加依赖即可

![image-20241228121911680](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228121911680.png)

编写controller，注意几个注解，提交方式是POST就用@PostMapping

![image-20241228122337412](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228122337412.png)

创建service对象，上面写上@Autowired

![image-20241228122847003](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228122847003.png)

![image-20241228122830384](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228122830384.png)

注册逻辑

![image-20241228123256513](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228123256513.png)

alt + 回车enther 实现快速创建未实现的函数

![image-20241228200548593](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228200548593.png)

alt + enter 实现接口方法

![image-20241228201022009](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228201022009.png)

添加注解@Service，注册到容器里

![image-20241228201122269](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228201122269.png)

同样步骤实现mapper方法

![image-20241228201440133](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228201440133.png)

对于register，要先加密，在写入数据库，用Md5Util工具加密，把文件夹里的相关文件复制到util中

![image-20241228201611143](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228201611143.png)

![image-20241228201809166](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228201809166.png)

在mapper接口中实现方法时，@Select 不显示，解决方法同上，添加依赖

![image-20241228202647798](C:\Users\HP.LAPTOP-JUSOBNLA\AppData\Roaming\Typora\typora-user-images\image-20241228202647798.png)

在mapper里@注解里写sql语句,并在接口类顶端写上@Mapper

![idea64.exe_20241229_095724](F:\腾讯电脑管家截图文件\idea64.exe_20241229_095724.png)

黄波浪线是在警告未配置sql方言

![idea64.exe_20241229_100411](F:\腾讯电脑管家截图文件\idea64.exe_20241229_100411.png)

配置好后还会爆红，是因为没有勾选架构，找不到username

![idea64.exe_20241229_102213](F:\腾讯电脑管家截图文件\idea64.exe_20241229_102213.png)

选择架构即可

![idea64.exe_20241229_102405](F:\腾讯电脑管家截图文件\idea64.exe_20241229_102405.png)

##### Mybatis只用接口就行？

![局部截取_20241229_102654](F:\腾讯电脑管家截图文件\局部截取_20241229_102654.png)

![局部截取_20241229_103112](F:\腾讯电脑管家截图文件\局部截取_20241229_103112.png)

##### service层为什么要写java类？

所以mapper只用接口实现，因为mybatis会帮忙，但service需要自己写逻辑。

![局部截取_20241229_103244](F:\腾讯电脑管家截图文件\局部截取_20241229_103244.png)

##### 借助postman来测试接口

创建工作空间Creat Workspace

![Postman.exe_20241229_103631](F:\腾讯电脑管家截图文件\Postman.exe_20241229_103631.png)

![Postman.exe_20241229_103710](F:\腾讯电脑管家截图文件\Postman.exe_20241229_103710.png)

![Postman.exe_20241229_103826](F:\腾讯电脑管家截图文件\Postman.exe_20241229_103826.png)

创建好工作空间后，还要创建工作集Collection

导入文件夹里提前准备好的文件

![Postman.exe_20241229_104030](F:\腾讯电脑管家截图文件\Postman.exe_20241229_104030.png)

![Postman.exe_20241229_104150](F:\腾讯电脑管家截图文件\Postman.exe_20241229_104150.png)

配置好postman后重启项目，点击Send即可

但启动项目的时候报错，原因是没有配置yml文件

##### 配置yml文件

![idea64.exe_20241229_105214](F:\腾讯电脑管家截图文件\idea64.exe_20241229_105214.png)

![局部截取_20241229_110343](F:\腾讯电脑管家截图文件\局部截取_20241229_110343.png)

如下配置号yml文件

![idea64.exe_20241229_110455](F:\腾讯电脑管家截图文件\idea64.exe_20241229_110455.png)

##### send提交post请求后，出现了空指针错误

![Postman.exe_20241229_110713](F:\腾讯电脑管家截图文件\Postman.exe_20241229_110713.png)

![idea64.exe_20241229_110642](F:\腾讯电脑管家截图文件\idea64.exe_20241229_110642.png)

![idea64.exe_20241229_111156](F:\腾讯电脑管家截图文件\idea64.exe_20241229_111156.png)

原因是没有添加autowired注解

![局部截取_20241229_111308](F:\腾讯电脑管家截图文件\局部截取_20241229_111308.png)

重新运行后又出现了错误

##### 错误：提示在user表中找不到username列（数据库名字url写错了，big_event而不是mysql）

![idea64.exe_20241229_111503](F:\腾讯电脑管家截图文件\idea64.exe_20241229_111503.png)

提示错误可能出现在mapper里：

![idea64.exe_20241229_112342](F:\腾讯电脑管家截图文件\idea64.exe_20241229_112342.png)

把yml文件里的mysql改成数据库名字big_event后就好了，注意这里连接的是数据库名字，而不是连接名字。

![idea64.exe_20241229_113023](F:\腾讯电脑管家截图文件\idea64.exe_20241229_113023.png)

重新运行

报错406

![Postman.exe_20241229_113301](F:\腾讯电脑管家截图文件\Postman.exe_20241229_113301.png)

![idea64.exe_20241229_113938](F:\腾讯电脑管家截图文件\idea64.exe_20241229_113938.png)

应该是忘记了@path注解（×）

启动的时候会要求启动lombok注解处理，点击处理即可。

把user ！= null 就可以写入到数据库里

![idea64.exe_20241229_114408](F:\腾讯电脑管家截图文件\idea64.exe_20241229_114408.png)

##### 错误：postman send提交后还是出现了406错误

![Postman.exe_20241229_142947](F:\腾讯电脑管家截图文件\Postman.exe_20241229_142947.png)

result没有添加@Data注解（@Data是lombok用于自动生成getter setter等）

![idea64.exe_20241229_143030](F:\腾讯电脑管家截图文件\idea64.exe_20241229_143030.png)

![局部截取_20241229_143639](F:\腾讯电脑管家截图文件\局部截取_20241229_143639.png)

修改后成功

![Postman.exe_20241229_143239](F:\腾讯电脑管家截图文件\Postman.exe_20241229_143239.png)

## 用户模块

### 注册接口参数校验

##### 判断是否合法

为了规范用户提交的数据，需要if判断校验

![idea64.exe_20241229_144235](F:\腾讯电脑管家截图文件\idea64.exe_20241229_144235.png)

![Postman.exe_20241229_144420](F:\腾讯电脑管家截图文件\Postman.exe_20241229_144420.png)

但这样太繁琐了

![msedge.exe_20241229_144508](F:\腾讯电脑管家截图文件\msedge.exe_20241229_144508.png)

使用Spring Validation对参数进行校验

![msedge.exe_20241229_144726](F:\腾讯电脑管家截图文件\msedge.exe_20241229_144726.png)

有的时候添加依赖会爆红，刷新maven可能会解决问题

![局部截取_20241229_145925](F:\腾讯电脑管家截图文件\局部截取_20241229_145925.png)

在需要参数校验处如下书写，参数里写@Pattern，类上写@Validated

![idea64.exe_20241229_150241](F:\腾讯电脑管家截图文件\idea64.exe_20241229_150241.png)

##### 错误：需要正则表达式

![idea64.exe_20241229_150535](F:\腾讯电脑管家截图文件\idea64.exe_20241229_150535.png)

##### 参数异常处理

![msedge.exe_20241229_150859](F:\腾讯电脑管家截图文件\msedge.exe_20241229_150859.png)

![idea64.exe_20241229_151750](F:\腾讯电脑管家截图文件\idea64.exe_20241229_151750.png)

成功处理了异常

![Postman.exe_20241229_151843](F:\腾讯电脑管家截图文件\Postman.exe_20241229_151843.png)

![msedge.exe_20241229_151909](F:\腾讯电脑管家截图文件\msedge.exe_20241229_151909.png)

### 登录接口

![msedge.exe_20241229_152333](F:\腾讯电脑管家截图文件\msedge.exe_20241229_152333.png)

##### 登录主逻辑

![idea64.exe_20241229_153324](F:\腾讯电脑管家截图文件\idea64.exe_20241229_153324.png)

![Postman.exe_20241229_153442](F:\腾讯电脑管家截图文件\Postman.exe_20241229_153442.png)

##### 登录认证JWT令牌token

引入令牌（web应用常用的就是jwt令牌），起到身份识别的作用，即需要登录才能查看文章

![msedge.exe_20241229_155319](F:\腾讯电脑管家截图文件\msedge.exe_20241229_155319.png)

![msedge.exe_20241229_155554](F:\腾讯电脑管家截图文件\msedge.exe_20241229_155554.png)

导入jwt坐标，如果识别不了就手动写上去，然后重新加载maven项目

![idea64.exe_20241229_160107](F:\腾讯电脑管家截图文件\idea64.exe_20241229_160107.png)

导入测试坐标

![idea64.exe_20241229_160259](F:\腾讯电脑管家截图文件\idea64.exe_20241229_160259.png)

测试生成jwt令牌

![idea64.exe_20241229_161119](F:\腾讯电脑管家截图文件\idea64.exe_20241229_161119.png)

测试验证token

![idea64.exe_20241229_161728](F:\腾讯电脑管家截图文件\idea64.exe_20241229_161728.png)

##### 生成JWT令牌token

导入工具类jwtutil文件

![idea64.exe_20241229_162223](F:\腾讯电脑管家截图文件\idea64.exe_20241229_162223.png)

在登录逻辑中加入jwt令牌

![idea64.exe_20241229_162744](F:\腾讯电脑管家截图文件\idea64.exe_20241229_162744.png)

成功生成token

![Postman.exe_20241229_162833](F:\腾讯电脑管家截图文件\Postman.exe_20241229_162833.png)

##### 验证token

验证token需要在其他service里写

ctrl + alt + v快速生成一个对象定义

![idea64.exe_20241229_163647](F:\腾讯电脑管家截图文件\idea64.exe_20241229_163647.png)

ctrl + alt + T 快速围绕try catch

![idea64.exe_20241229_163931](F:\腾讯电脑管家截图文件\idea64.exe_20241229_163931.png)

写好后的逻辑：

![idea64.exe_20241229_164655](F:\腾讯电脑管家截图文件\idea64.exe_20241229_164655.png)

![msedge.exe_20241229_164608](F:\腾讯电脑管家截图文件\msedge.exe_20241229_164608.png)

##### token小结

首先在UserController里，当登录成功后，将username,password写入claims，然后生成token，返回给浏览器（客户端），这里的返回给客户端其实是先返回给springboot框架，然后springboot框架再将其转换成HTTP响应发送给浏览器（客户端）

![idea64.exe_20241230_203539](F:\腾讯电脑管家截图文件\idea64.exe_20241230_203539.png)

浏览器接受到token后会存储起来，每次请求的时候，后端会验证其中的token

![idea64.exe_20241230_205826](F:\腾讯电脑管家截图文件\idea64.exe_20241230_205826.png)

## 12.30

##### postman来测试接口

![Postman.exe_20241230_134657](F:\腾讯电脑管家截图文件\Postman.exe_20241230_134657.png)

![Postman.exe_20241230_134918](F:\腾讯电脑管家截图文件\Postman.exe_20241230_134918.png)

并没有携带请求头，导致无法访问list

在Hearder里添加请求头，输入token，再次send，发现成功

![Postman.exe_20241230_135200](F:\腾讯电脑管家截图文件\Postman.exe_20241230_135200.png)

##### 拦截器

每个请求都要验证，为了避免每个请求都写token验证，可以用拦截器（步骤：1、写拦截器 2、在配置类中注册拦截器）

![msedge.exe_20241230_135327](F:\腾讯电脑管家截图文件\msedge.exe_20241230_135327.png)

![msedge.exe_20241230_135541](F:\腾讯电脑管家截图文件\msedge.exe_20241230_135541.png)

![idea64.exe_20241230_135859](F:\腾讯电脑管家截图文件\idea64.exe_20241230_135859.png)

![idea64.exe_20241230_140055](F:\腾讯电脑管家截图文件\idea64.exe_20241230_140055.png)

新建config软件包

![idea64.exe_20241230_140512](F:\腾讯电脑管家截图文件\idea64.exe_20241230_140512.png)

每次网站请求前都会先调用preHandle方法，true才会继续执行后续service

![msedge.exe_20241230_200425](F:\腾讯电脑管家截图文件\msedge.exe_20241230_200425.png)

![msedge.exe_20241230_200554](F:\腾讯电脑管家截图文件\msedge.exe_20241230_200554.png)

![msedge.exe_20241230_202354](F:\腾讯电脑管家截图文件\msedge.exe_20241230_202354.png)

将之前写的token验证去掉，重新验证

![idea64.exe_20241230_140822](F:\腾讯电脑管家截图文件\idea64.exe_20241230_140822.png)

##### 错误：刚开始拦截器并不能正常拦截

![idea64.exe_20241230_141549](F:\腾讯电脑管家截图文件\idea64.exe_20241230_141549.png)

原因是@注解写错了，应该是Configuration

修改后在postman中去掉Authorization重新send，成功拦截

![Postman.exe_20241230_141706](F:\腾讯电脑管家截图文件\Postman.exe_20241230_141706.png)

### 获取用户信息

![msedge.exe_20241230_141924](F:\腾讯电脑管家截图文件\msedge.exe_20241230_141924.png)

根据已登录的用户查找相应用户，通过token

##### 写代码

![msedge.exe_20241230_191049](F:\腾讯电脑管家截图文件\msedge.exe_20241230_191049.png)

书写获取信息的controller，由于里面的findbyusername已经在service和mapper里写好了，故只需在controller里写

![idea64.exe_20241230_192359](F:\腾讯电脑管家截图文件\idea64.exe_20241230_192359.png)

postman测试接口，注意别忘记携带token

![Postman.exe_20241230_192615](F:\腾讯电脑管家截图文件\Postman.exe_20241230_192615.png)

##### postman统一携带请求头

![Postman.exe_20241230_192803](F:\腾讯电脑管家截图文件\Postman.exe_20241230_192803.png)

忽略password属性，返回的时候就不用password了

![idea64.exe_20241230_193615](F:\腾讯电脑管家截图文件\idea64.exe_20241230_193615.png)

第一次引用的第二个，导致结果不对

![idea64.exe_20241230_193652](F:\腾讯电脑管家截图文件\idea64.exe_20241230_193652.png)

![Postman.exe_20241230_193551](F:\腾讯电脑管家截图文件\Postman.exe_20241230_193551.png)

##### 问题：没有返回creatTime和updateTime

为什么没有返回createTime 和 updateTime？因为在数据库里命名不同，数据库里有下划线

![idea64.exe_20241230_193905](F:\腾讯电脑管家截图文件\idea64.exe_20241230_193905.png)

解决方法：在yml文件里配置映射，写个camel 会自动提示补全

![idea64.exe_20241230_194312](F:\腾讯电脑管家截图文件\idea64.exe_20241230_194312.png)

![Postman.exe_20241230_194329](F:\腾讯电脑管家截图文件\Postman.exe_20241230_194329.png)

##### ThreadLocal优化

![msedge.exe_20241230_194601](F:\腾讯电脑管家截图文件\msedge.exe_20241230_194601.png)

![msedge.exe_20241230_195014](F:\腾讯电脑管家截图文件\msedge.exe_20241230_195014.png)

test演示：

![idea64.exe_20241230_195600](F:\腾讯电脑管家截图文件\idea64.exe_20241230_195600.png)

![idea64.exe_20241230_195632](F:\腾讯电脑管家截图文件\idea64.exe_20241230_195632.png)

先把文件粘贴到utils里

![idea64.exe_20241230_200909](F:\腾讯电脑管家截图文件\idea64.exe_20241230_200909.png)

在拦截器里添加ThreadLocal对象

![idea64.exe_20241230_201238](F:\腾讯电脑管家截图文件\idea64.exe_20241230_201238.png)

把token添加ThreadLocal后，后续使用只需要调用ThreadLocal.get()方法即可

![idea64.exe_20241230_210359](F:\腾讯电脑管家截图文件\idea64.exe_20241230_210359.png)

使用完后要释放内存，防止内存泄漏

![idea64.exe_20241230_210052](F:\腾讯电脑管家截图文件\idea64.exe_20241230_210052.png)

## 12.31

### 更新用户基本信息

##### 写代码

![msedge.exe_20241231_142728](F:\腾讯电脑管家截图文件\msedge.exe_20241231_142728.png)

![msedge.exe_20241231_143006](F:\腾讯电脑管家截图文件\msedge.exe_20241231_143006.png)

controller层

![idea64.exe_20241231_143131](F:\腾讯电脑管家截图文件\idea64.exe_20241231_143131.png)

接口和service层

![idea64.exe_20241231_143442](F:\腾讯电脑管家截图文件\idea64.exe_20241231_143442.png)

![idea64.exe_20241231_143428](F:\腾讯电脑管家截图文件\idea64.exe_20241231_143428.png)

mapper层

![idea64.exe_20241231_143724](F:\腾讯电脑管家截图文件\idea64.exe_20241231_143724.png)

![局部截取_20241231_144013](F:\腾讯电脑管家截图文件\局部截取_20241231_144013.png)

![Postman.exe_20241231_144533](F:\腾讯电脑管家截图文件\Postman.exe_20241231_144533.png)

##### 实体参数校验

如何对@RequestBodey user完成校验？ 

![msedge.exe_20241231_144716](F:\腾讯电脑管家截图文件\msedge.exe_20241231_144716.png)

![msedge.exe_20241231_144859](F:\腾讯电脑管家截图文件\msedge.exe_20241231_144859.png)

![idea64.exe_20241231_145615](F:\腾讯电脑管家截图文件\idea64.exe_20241231_145615.png)

在controller层加上@Validated后上面的注解才能生效

![idea64.exe_20241231_145642](F:\腾讯电脑管家截图文件\idea64.exe_20241231_145642.png)

![Postman.exe_20241231_145937](F:\腾讯电脑管家截图文件\Postman.exe_20241231_145937.png)

##### 更新用户头像

![msedge.exe_20241231_150220](F:\腾讯电脑管家截图文件\msedge.exe_20241231_150220.png)

![msedge.exe_20241231_150250](F:\腾讯电脑管家截图文件\msedge.exe_20241231_150250.png)

![msedge.exe_20241231_150440](F:\腾讯电脑管家截图文件\msedge.exe_20241231_150440.png)

##### 写代码

controller层

![idea64.exe_20241231_150753](F:\腾讯电脑管家截图文件\idea64.exe_20241231_150753.png)

![局部截取_20241231_150943](F:\腾讯电脑管家截图文件\局部截取_20241231_150943.png)

![局部截取_20241231_151054](F:\腾讯电脑管家截图文件\局部截取_20241231_151054.png)

service层

快捷键alt + enter 快速实现方法

![idea64.exe_20241231_151456](F:\腾讯电脑管家截图文件\idea64.exe_20241231_151456.png)

mapper层

为了找到指定的用户id，可以在service层通过ThreadLocal获得id，然后传给mapper层

![局部截取_20241231_152625](F:\腾讯电脑管家截图文件\局部截取_20241231_152625.png)

![局部截取_20241231_152522](F:\腾讯电脑管家截图文件\局部截取_20241231_152522.png)

注意这里@Update获取的参数都是下面函数里的参数，updateTime不在参数里，需要改一下

![局部截取_20241231_153017](F:\腾讯电脑管家截图文件\局部截取_20241231_153017.png)

##### 校验传过来的头像地址

在controller层参数里面加上@URL注释，即可判断后面传递的avatarUrl是否是合法的Url

![局部截取_20241231_153256](F:\腾讯电脑管家截图文件\局部截取_20241231_153256.png)

![Postman.exe_20241231_153434](F:\腾讯电脑管家截图文件\Postman.exe_20241231_153434.png)

### 更新密码

功能描述：

![msedge.exe_20241231_153543](F:\腾讯电脑管家截图文件\msedge.exe_20241231_153543.png)

接口文档

![msedge.exe_20241231_153559](F:\腾讯电脑管家截图文件\msedge.exe_20241231_153559.png)

@RequestBody会把输入的信息转换成后面的params

![msedge.exe_20241231_153800](F:\腾讯电脑管家截图文件\msedge.exe_20241231_153800.png)

##### 写代码

controller层

![局部截取_20241231_155343](F:\腾讯电脑管家截图文件\局部截取_20241231_155343.png)

![局部截取_20241231_163259](F:\腾讯电脑管家截图文件\局部截取_20241231_163259.png)

![局部截取_20241231_155351](F:\腾讯电脑管家截图文件\局部截取_20241231_155351.png)

别忘记传入ID

![局部截取_20241231_160117](F:\腾讯电脑管家截图文件\局部截取_20241231_160117.png)

service层

![idea64.exe_20241231_160210](F:\腾讯电脑管家截图文件\idea64.exe_20241231_160210.png)

mapper层

![idea64.exe_20241231_160231](F:\腾讯电脑管家截图文件\idea64.exe_20241231_160231.png)

需要注意，由于存入数据库的密码是经过加密后处理的，所以不能直接传newpwd，应该加密后再传入数据库

![idea64.exe_20241231_160932](F:\腾讯电脑管家截图文件\idea64.exe_20241231_160932.png)

![Postman.exe_20241231_161210](F:\腾讯电脑管家截图文件\Postman.exe_20241231_161210.png)

![局部截取_20241231_161909](F:\腾讯电脑管家截图文件\局部截取_20241231_161909.png)

## 文章分类模块

![msedge.exe_20241231_162754](F:\腾讯电脑管家截图文件\msedge.exe_20241231_162754.png)

### 模块：新增文章分类

需求

![msedge.exe_20241231_163037](F:\腾讯电脑管家截图文件\msedge.exe_20241231_163037.png)

接口文档

![msedge.exe_20241231_163054](F:\腾讯电脑管家截图文件\msedge.exe_20241231_163054.png)

思路分析

![msedge.exe_20241231_163428](F:\腾讯电脑管家截图文件\msedge.exe_20241231_163428.png)

#### 初始化相关文件controller、service、mapper

![局部截取_20241231_163655](F:\腾讯电脑管家截图文件\局部截取_20241231_163655.png)

实现接口并添加注解

mapper层：添加@Mapper注解

![idea64.exe_20241231_163836](F:\腾讯电脑管家截图文件\idea64.exe_20241231_163836.png)

service层：实现接口，并添加@Service注解

![idea64.exe_20241231_163934](F:\腾讯电脑管家截图文件\idea64.exe_20241231_163934.png)

controller层：在类名上方添加@RestController 和 @RequestMapping注解，在方法上添加@PostMapping注解，参数内部添加@RequestBody注解

![idea64.exe_20241231_164217](F:\腾讯电脑管家截图文件\idea64.exe_20241231_164217.png)

要使用service服务，要添加@Autowired注解

![局部截取_20241231_164758](F:\腾讯电脑管家截图文件\局部截取_20241231_164758.png)

完整controller层：

![idea64.exe_20241231_164849](F:\腾讯电脑管家截图文件\idea64.exe_20241231_164849.png)

然后alt+enter自动在Service接口层创建add方法

![idea64.exe_20241231_164916](F:\腾讯电脑管家截图文件\idea64.exe_20241231_164916.png)

然后再service层实现接口方法

![idea64.exe_20241231_165214](F:\腾讯电脑管家截图文件\idea64.exe_20241231_165214.png)

在service要使用mapper层方法，要先定义private mapper

![idea64.exe_20241231_165310](F:\腾讯电脑管家截图文件\idea64.exe_20241231_165310.png)

service完整代码：

![idea64.exe_20241231_165854](F:\腾讯电脑管家截图文件\idea64.exe_20241231_165854.png)

在mapper层实现上述add方法

alt+enter跳转到mapper接口，然后开始写sql语句（基于Mybatis框架）

![idea64.exe_20241231_165952](F:\腾讯电脑管家截图文件\idea64.exe_20241231_165952.png)

完整mapper层：注意#{}里面的值是属性名的值，也就是pojo里定义的变量名

![idea64.exe_20241231_170422](F:\腾讯电脑管家截图文件\idea64.exe_20241231_170422.png)

#### 导入相关postman测试接口样例

![Postman.exe_20241231_190237](F:\腾讯电脑管家截图文件\Postman.exe_20241231_190237.png)

第一次send失败了，原因是请求头token写错了，忘记加authorization

![Postman.exe_20241231_191043](F:\腾讯电脑管家截图文件\Postman.exe_20241231_191043.png)

修改后提交成功

![Postman.exe_20241231_191454](F:\腾讯电脑管家截图文件\Postman.exe_20241231_191454.png)

#### 出错：userId为空

猜测应该是map.get("id")出错，

![idea64.exe_20241231_192212](F:\腾讯电脑管家截图文件\idea64.exe_20241231_192212.png)

但是修改密码能打印出id

![idea64.exe_20241231_194007](F:\腾讯电脑管家截图文件\idea64.exe_20241231_194007.png)

这里通过ThreadLocalUtil拿到token后，可以通过username找到用户，进而通过loginuser.getId()得到id，这样是正确的

![局部截取_20241231_194106](F:\腾讯电脑管家截图文件\局部截取_20241231_194106.png)

果然，map里没有id这个键

![idea64.exe_20241231_194700](F:\腾讯电脑管家截图文件\idea64.exe_20241231_194700.png)

原因出自这里：定义token的时候只用了username和password

![idea64.exe_20241231_194926](F:\腾讯电脑管家截图文件\idea64.exe_20241231_194926.png)

加上id后，别忘记重新登录一下获得新的token

![Postman.exe_20241231_195355](F:\腾讯电脑管家截图文件\Postman.exe_20241231_195355.png)

#### 在controller对传入的参数进行校验

在实体层加入@Notempty注解 并且在Controller层加上@Validated注解

![idea64.exe_20241231_195738](F:\腾讯电脑管家截图文件\idea64.exe_20241231_195738.png)

在controller加入@Validated注解

![idea64.exe_20241231_195931](F:\腾讯电脑管家截图文件\idea64.exe_20241231_195931.png)

![msedge.exe_20241231_200213](F:\腾讯电脑管家截图文件\msedge.exe_20241231_200213.png)

### 模块：文章分类列表

需求

![msedge.exe_20241231_200238](F:\腾讯电脑管家截图文件\msedge.exe_20241231_200238.png)

接口文档

![msedge.exe_20241231_200256](F:\腾讯电脑管家截图文件\msedge.exe_20241231_200256.png)

![msedge.exe_20241231_201531](F:\腾讯电脑管家截图文件\msedge.exe_20241231_201531.png)

思路

![msedge.exe_20241231_201619](F:\腾讯电脑管家截图文件\msedge.exe_20241231_201619.png)

#### 写代码

controller层：

![idea64.exe_20241231_202645](F:\腾讯电脑管家截图文件\idea64.exe_20241231_202645.png)

service层：

![idea64.exe_20241231_202119](F:\腾讯电脑管家截图文件\idea64.exe_20241231_202119.png)

mapper层：

![idea64.exe_20241231_202250](F:\腾讯电脑管家截图文件\idea64.exe_20241231_202250.png)

![Postman.exe_20241231_202815](F:\腾讯电脑管家截图文件\Postman.exe_20241231_202815.png)

但createTime时间格式不太符合规矩

#### 修改时间格式

利用注解，在实体类里添加@JsonFormat注解

![idea64.exe_20241231_203121](F:\腾讯电脑管家截图文件\idea64.exe_20241231_203121.png)

成功返回正确格式时间

![Postman.exe_20241231_203156](F:\腾讯电脑管家截图文件\Postman.exe_20241231_203156.png)

### 模块：获取文章分类详情

需求

![msedge.exe_20241231_203353](F:\腾讯电脑管家截图文件\msedge.exe_20241231_203353.png)

接口文档：

![msedge.exe_20241231_203534](F:\腾讯电脑管家截图文件\msedge.exe_20241231_203534.png)

思路

![msedge.exe_20241231_203618](F:\腾讯电脑管家截图文件\msedge.exe_20241231_203618.png)

#### 写代码

controller层：

![idea64.exe_20241231_203949](F:\腾讯电脑管家截图文件\idea64.exe_20241231_203949.png)

为什么传参用Integer而不是int：

![局部截取_20241231_203908](F:\腾讯电脑管家截图文件\局部截取_20241231_203908.png)

@RestController 、 @RequestMapping 、@PostMapping @GetMapping

![局部截取_20241231_204447](F:\腾讯电脑管家截图文件\局部截取_20241231_204447.png)

![局部截取_20241231_204555](F:\腾讯电脑管家截图文件\局部截取_20241231_204555.png)

![局部截取_20241231_204707](F:\腾讯电脑管家截图文件\局部截取_20241231_204707.png)

![局部截取_20241231_204832](F:\腾讯电脑管家截图文件\局部截取_20241231_204832.png)

service层：

![idea64.exe_20241231_205047](F:\腾讯电脑管家截图文件\idea64.exe_20241231_205047.png)

mapper层：

![idea64.exe_20241231_205204](F:\腾讯电脑管家截图文件\idea64.exe_20241231_205204.png)

成功返回数据

![Postman.exe_20241231_205318](F:\腾讯电脑管家截图文件\Postman.exe_20241231_205318.png)

## 1.1

### 模块：更新文章分类

![msedge.exe_20250101_095532](F:\腾讯电脑管家截图文件\msedge.exe_20250101_095532.png)

接口文档

![msedge.exe_20250101_095538](F:\腾讯电脑管家截图文件\msedge.exe_20250101_095538.png)

思路

![msedge.exe_20250101_095806](F:\腾讯电脑管家截图文件\msedge.exe_20250101_095806.png)

#### 写代码

controller层：

@PutMapping表示浏览器提交方式，@RequestBody表示把浏览器提交的数据转换成Category，@Validated 表示对浏览器输入的数据进行非空校验

![idea64.exe_20250101_095853](F:\腾讯电脑管家截图文件\idea64.exe_20250101_095853.png)

NotNull表示必须传，Empty表示不仅必须传，还不能为空值

![idea64.exe_20250101_100106](F:\腾讯电脑管家截图文件\idea64.exe_20250101_100106.png)

通过categoryService对象调用其方法

![idea64.exe_20250101_100222](F:\腾讯电脑管家截图文件\idea64.exe_20250101_100222.png)

service层：

定义接口，实现接口

![idea64.exe_20250101_100354](F:\腾讯电脑管家截图文件\idea64.exe_20250101_100354.png)

在service还要把category属性补全

![idea64.exe_20250101_100709](F:\腾讯电脑管家截图文件\idea64.exe_20250101_100709.png)

mapper层：写sql语句

![idea64.exe_20250101_101045](F:\腾讯电脑管家截图文件\idea64.exe_20250101_101045.png)

![Postman.exe_20250101_101218](F:\腾讯电脑管家截图文件\Postman.exe_20250101_101218.png)

#### @Validation分组校验解决bug

因为在实体上添加了@NotNull等注解，导致了@Validation必须要符合规定，但并不是所有的函数检验规则都一样，所以出现了分组校验

![idea64.exe_20250101_101802](F:\腾讯电脑管家截图文件\idea64.exe_20250101_101802.png)

添加函数对数据提交有一组规则，更新也有一组规则，可以用@Validation注解的分组校验

![msedge.exe_20250101_102113](F:\腾讯电脑管家截图文件\msedge.exe_20250101_102113.png)

第一步，在category属性中定义分组接口以及为属性标记属于哪个group

![idea64.exe_20250101_102334](F:\腾讯电脑管家截图文件\idea64.exe_20250101_102334.png)

第二步，在Controller层里的@Validation修改格式

![局部截取_20250101_102604](F:\腾讯电脑管家截图文件\局部截取_20250101_102604.png)

![Postman.exe_20250101_103014](F:\腾讯电脑管家截图文件\Postman.exe_20250101_103014.png)

在@Validation中如果某个校验项没有指定分组，默认default分组

![idea64.exe_20250101_103537](F:\腾讯电脑管家截图文件\idea64.exe_20250101_103537.png)

### 模块：删除文章分类（自己写）

接口文档

![局部截取_20250101_105848](F:\腾讯电脑管家截图文件\局部截取_20250101_105848.png)



![局部截取_20250101_110030](F:\腾讯电脑管家截图文件\局部截取_20250101_110030.png)

![局部截取_20250101_112553](F:\腾讯电脑管家截图文件\局部截取_20250101_112553.png)

#### 写代码

controller层

删除某个文章列表，浏览器请求方式为Delete

![idea64.exe_20250101_113042](F:\腾讯电脑管家截图文件\idea64.exe_20250101_113042.png)

service层

![局部截取_20250101_113053](F:\腾讯电脑管家截图文件\局部截取_20250101_113053.png)

mapper层

![idea64.exe_20250101_113113](F:\腾讯电脑管家截图文件\idea64.exe_20250101_113113.png)

![Postman.exe_20250101_113807](F:\腾讯电脑管家截图文件\Postman.exe_20250101_113807.png)

## 文章管理模块

![msedge.exe_20250101_113923](F:\腾讯电脑管家截图文件\msedge.exe_20250101_113923.png)

### 初始化相关文件

开发一个新的大模块，先创建相关文件

controller、service接口、service、mapper等

==controller层,写上@RestController和@RequestMapping注解==

![idea64.exe_20250101_115048](F:\腾讯电脑管家截图文件\idea64.exe_20250101_115048.png)

==service接口以及serviceimpl，注意在serviceimpl里写上@Service==

![idea64.exe_20250101_115121](F:\腾讯电脑管家截图文件\idea64.exe_20250101_115121.png)

![idea64.exe_20250101_115110](F:\腾讯电脑管家截图文件\idea64.exe_20250101_115110.png)

==mapper层写上@Mapper注解==

![idea64.exe_20250101_120111](F:\腾讯电脑管家截图文件\idea64.exe_20250101_120111.png)



### 模块:新增文章

需求

![msedge.exe_20250101_114211](F:\腾讯电脑管家截图文件\msedge.exe_20250101_114211.png)

接口文档

![msedge.exe_20250101_114249](F:\腾讯电脑管家截图文件\msedge.exe_20250101_114249.png)

![msedge.exe_20250101_114400](F:\腾讯电脑管家截图文件\msedge.exe_20250101_114400.png)

思路

![msedge.exe_20250101_114509](F:\腾讯电脑管家截图文件\msedge.exe_20250101_114509.png)

#### 写代码

controller层：

![idea64.exe_20250101_193913](F:\腾讯电脑管家截图文件\idea64.exe_20250101_193913.png)

service层

![idea64.exe_20250101_194304](F:\腾讯电脑管家截图文件\idea64.exe_20250101_194304.png)

mapper层：

![idea64.exe_20250101_194652](F:\腾讯电脑管家截图文件\idea64.exe_20250101_194652.png)

问题：删除id为3的数据项后，下次插入的id为4，原因在于自增主键

![idea64.exe_20250101_195638](F:\腾讯电脑管家截图文件\idea64.exe_20250101_195638.png)

![局部截取_20250101_195615](F:\腾讯电脑管家截图文件\局部截取_20250101_195615.png)

#### 参数校验（自定义@Validation）

![msedge.exe_20250101_200751](F:\腾讯电脑管家截图文件\msedge.exe_20250101_200751.png)

第一步，在实体类属性里写注解

![idea64.exe_20250101_201048](F:\腾讯电脑管家截图文件\idea64.exe_20250101_201048.png)

第二步，在controller层参数前面加上@Validated

![idea64.exe_20250101_201159](F:\腾讯电脑管家截图文件\idea64.exe_20250101_201159.png)

#### 自定义校验

对于state属性，目前的注解规则无法满足要求，这就需要用到自定义校验

![msedge.exe_20250101_201534](F:\腾讯电脑管家截图文件\msedge.exe_20250101_201534.png)

第一步，新建anno软件包，创建State注解类

![idea64.exe_20250101_202026](F:\腾讯电脑管家截图文件\idea64.exe_20250101_202026.png)

第三步，新建validation软件包，创建StateValidation类，并编写校验规则代码

![idea64.exe_20250101_202847](F:\腾讯电脑管家截图文件\idea64.exe_20250101_202847.png)

![idea64.exe_20250101_203415](F:\腾讯电脑管家截图文件\idea64.exe_20250101_203415.png)

第四步，在State接口中的@Constraint赋值，指定提供校验规则的类

![idea64.exe_20250101_203537](F:\腾讯电脑管家截图文件\idea64.exe_20250101_203537.png)

第五步，在哪里需要校验，在哪里添加注解即可

![idea64.exe_20250101_203721](F:\腾讯电脑管家截图文件\idea64.exe_20250101_203721.png)

自定义校验规则已生效：

![Postman.exe_20250101_204220](F:\腾讯电脑管家截图文件\Postman.exe_20250101_204220.png)

### 模块：文章列表

需求：

![msedge.exe_20250101_204354](F:\腾讯电脑管家截图文件\msedge.exe_20250101_204354.png)

接口文档

![msedge.exe_20250101_204458](F:\腾讯电脑管家截图文件\msedge.exe_20250101_204458.png)

![msedge.exe_20250101_204557](F:\腾讯电脑管家截图文件\msedge.exe_20250101_204557.png)

思路

![msedge.exe_20250101_204804](F:\腾讯电脑管家截图文件\msedge.exe_20250101_204804.png)

![msedge.exe_20250101_205016](F:\腾讯电脑管家截图文件\msedge.exe_20250101_205016.png)

#### 写代码

导入Bean定义文件到pojo中

![idea64.exe_20250101_205306](F:\腾讯电脑管家截图文件\idea64.exe_20250101_205306.png)

controller层：

@RequestParam（required = false）表示从浏览器传来的参数可以没有这项

![局部截取_20250101_205623](F:\腾讯电脑管家截图文件\局部截取_20250101_205623.png)

完整controller层

![idea64.exe_20250101_205902](F:\腾讯电脑管家截图文件\idea64.exe_20250101_205902.png)

##### service层：调用PageHelper

![idea64.exe_20250101_211942](F:\腾讯电脑管家截图文件\idea64.exe_20250101_211942.png)

如果写依赖的时候没有依赖项就手写

![局部截取_20250101_211130](F:\腾讯电脑管家截图文件\局部截取_20250101_211130.png)

##### mapper层：通过映射配置文件写sql语句

在resource中创建相关文件，路径和src中mapper路径相同

![idea64.exe_20250101_212348](F:\腾讯电脑管家截图文件\idea64.exe_20250101_212348.png)

导入相关xml文件

![idea64.exe_20250101_212537](F:\腾讯电脑管家截图文件\idea64.exe_20250101_212537.png)

编写xml文件

![idea64.exe_20250102_193221](F:\腾讯电脑管家截图文件\idea64.exe_20250102_193221.png)

注意路径不要写错了

![idea64.exe_20250102_195415](F:\腾讯电脑管家截图文件\idea64.exe_20250102_195415.png)

##### 问题：pagehelper无法启动

但提交后总是会报错，怀疑是访问github网络问题，但开加速器后还是不行

![Postman.exe_20250102_204953](F:\腾讯电脑管家截图文件\Postman.exe_20250102_204953.png)

![idea64.exe_20250102_205009](F:\腾讯电脑管家截图文件\idea64.exe_20250102_205009.png)

deepseek说肯能是没有开启分页查询，也就是第二步

![局部截取_20250102_205804](F:\腾讯电脑管家截图文件\局部截取_20250102_205804.png)

![idea64.exe_20250102_205649](F:\腾讯电脑管家截图文件\idea64.exe_20250102_205649.png)

应该是解析maven依赖网速的问题，换成视频里的1.4.6版本后，然后重新加载maven工程，等了半天才加载完，加载完后再postman就成功了

![Postman.exe_20250102_211046](F:\腾讯电脑管家截图文件\Postman.exe_20250102_211046.png)

换回最新的6.1.0版本后测试，又不行了

![idea64.exe_20250102_211351](F:\腾讯电脑管家截图文件\idea64.exe_20250102_211351.png)

应该是导入错了，应该导入带有start的依赖

![msedge.exe_20250102_211634](F:\腾讯电脑管家截图文件\msedge.exe_20250102_211634.png)

导入中，需要耐心等他导完

![idea64.exe_20250102_211744](F:\腾讯电脑管家截图文件\idea64.exe_20250102_211744.png)

解析依赖的时候需要访问github去下载依赖，访问速度比较慢，但解析好了之后运行就不再需要网络了，这也就解释了为什么前几次不成功

![局部截取_20250102_211909](F:\腾讯电脑管家截图文件\局部截取_20250102_211909.png)

成功：

![idea64.exe_20250102_212032](F:\腾讯电脑管家截图文件\idea64.exe_20250102_212032.png)

![Postman.exe_20250102_212020](F:\腾讯电脑管家截图文件\Postman.exe_20250102_212020.png)

