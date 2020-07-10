# File与IO流

## 一、文件对象（File）
### 1、创建文件对象：File f = new File(“文件路径”)
### 2、打印文件路径：System.out.println(f)
### 3、判断文件存在：f.exists()
### 4、判断是否文件夹：f.isDirectory()
### 5、判断是否文件：f.isFile()
### 6、文件长度：f.length()
### 7、文件修改时间：f.lastModified()
### 8、字符串形式返回当前文件夹下所有文件：f.list()
### 9、文件数组返回当前文件夹下所有文件：File[]fs= f.listFiles()
### 10、字符串形式返回获取所在文件夹：f.getParent()
### 11、文件形式返回获取所在文件夹：f.getParentFile()
### 12、创建单个文件夹：f.mkdir()
### 13、创建多级文件夹：f.mkdirs()
### 14、创建空文件,父文件夹不存在时抛出异常：f.createNewFile()
### 15、刪除文件：f.delete()

## 二、字节流（byte_stream）

## 三、关闭流的方式

## 四、字符流

## 五、缓存流（buffered_stream）

## 六、数据流

## 七、对象流（object_stream）

## 八、System。in
