## 12.26

### idea激活：

idea保存到了D盘，idea2024是安装包所在位置，idea_2024是idea所在位置；

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

git push -u origin master 提交到远端仓库

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
