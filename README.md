---
#QiYuanAPP
-------------

 
 
####项目背景:
智慧园区旨在通过“感知”系统，在传统园区各单一系统间实现“互联”，并通过多维度“智能”分析，借助云计算、物联网等IT技术有效整合，使园区基础设施运行更加智能、绿色；使园区的运营管理更加规范与高效；使园区为客户提供更加高质与便捷的增值服务体系，以提升园区的差异化竞争优势，进而去改善园区以往相对单一的盈利模式，进而打造一个更专业，更贴心，更人性的园区。
 

####项目内容:  
完成一个智慧园区的APP，使用用户包括园区管理员，企业管理员和普通用户  
管理员拥有普通用户的权限以及审批普通用户的申请，普通用户权限包括几大部分： 
- 一卡通
- 加入园区（企业）
- 车位使用
- 访客申请
- 出行权限
- 监控查看  
- 企业缴费  


####开发过程  
项目由五人共同完成，分成多个部分多个阶段完成，由于实习时间短暂，仅参与了此软件开发的部分过程

- 第一阶段  
完成了普通用户-加入企业、加入园区、出行权限申请、访客权限申请、监控查看申请  
- 第二阶段
完成了园区管理员个人中心，手机端-设置页面-标注    
- 第三阶段
完成了园区管理员-设备报修和投诉处理  
 

### 下载安装
Gradle: 2.3.3' 
compileSdkVersion: 25  
buildToolsVersion: "26.0.0"  

compile fileTree(dir: 'libs', include: ['*.jar'])  
compile 'com.android.support:appcompat-v7:25.3.1'  
compile 'com.android.support:recyclerview-v7:25.3.1'  

###TODO  
部分需要后端数据支持的地方用mockdata代替，下一步将要完成与后端联调
 

