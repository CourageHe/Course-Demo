# 天气预报及XML

## 一、中国天气网API

&emsp;&emsp;中国天气网官方api接口已经停止更新，因此许多以前的博客上的api接口已经失效。因为最近布置了一个关于天气预报的作业，因此以作记录找到的api。

### 1.1 Json格式的预报

请求方式：http get

返回：gzip格式压缩的文件

抓包接口:`http://wthrcdn.etouch.cn/weather_mini?city=北京`

或者以城市代码：`http://wthrcdn.etouch.cn/weather_mini?citykey=101010100`

**以下为手动缩进后的Json文件：**

```json
{
    "data":
    {
        "yesterday":{
                        "date":"14日星期一",
                        "high":"高温 15℃",
                        "fx":"北风",
                        "low":"低温 3℃",
                        "fl":"<![CDATA[3-4级]]>",
                        "type":"晴"
                    },
        "city":"北京",
            "forecast":
            [
                {
                    "date":"15日星期二",
                    "high":"高温 17℃",
                    "fengli":"<![CDATA[<3级]]>",
                    "low":"低温 6℃",
                    "fengxiang":"西南风",
                    "type":"晴"
                },
                {
                    "date":"16日星期三",
                    "high":"高温 15℃",
                    "fengli":"<![CDATA[<3级]]>",
                    "low":"低温 9℃",
                    "fengxiang":"西风",
                    "type":"阴"
                },
                {
                    "date":"17日星期四",
                    "high":"高温 13℃",
                    "fengli":"<![CDATA[<3级]]>",
                    "low":"低温 7℃",
                    "fengxiang":"西北风",
                    "type":"小雨"},
                {
                    "date":"18日星期五",
                    "high":"高温 17℃",
                    "fengli":"<![CDATA[<3级]]>",
                    "low":"低温 8℃",
                    "fengxiang":"西南风",
                    "type":"多云"},
                {
                    "date":"19日星期六",
                    "high":"高温 19℃",
                    "fengli":"<![CDATA[<3级]]>",
                    "low":"低温 10℃",
                    "fengxiang":"北风",
                    "type":"多云"
                }
            ],
    "ganmao":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。",
    "wendu":"16"
    },
    "status":1000,
    "desc":"OK"
}
```

### 1.2  XML格式的预报

请求方式：http get

返回：gzip格式压缩的文件

抓包接口:`http://wthrcdn.etouch.cn/WeatherApi?city=北京`

或者以城市代码：`http://wthrcdn.etouch.cn/WeatherApi?citykey=101010100`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<resp>
    <city>北京</city>
    <updatetime>17:39</updatetime>
    <wendu>12</wendu>
    <fengli><![CDATA[3级]]></fengli>
    <shidu>56%</shidu>
    <fengxiang>西南风</fengxiang>
    <sunrise_1>06:25</sunrise_1>
    <sunset_1>17:34</sunset_1>
    <sunrise_2></sunrise_2>
    <sunset_2></sunset_2><yesterday>
    <date_1>15日星期二</date_1>
    <high_1>高温 17℃</high_1>
    <low_1>低温 6℃</low_1>
    <day_1>
        <type_1>晴</type_1>
        <fx_1>西南风</fx_1>
        <fl_1><![CDATA[<3级]]></fl_1>
    </day_1>
    <night_1>
    <type_1>多云</type_1>
    <fx_1>西南风</fx_1>
    <fl_1><![CDATA[<3级]]></fl_1>
    </night_1>
    </yesterday>
    <forecast>
        <weather>
            <date>16日星期三</date>
            <high>高温 15℃</high>
            <low>低温 9℃</low><day>
            <type>阴</type>
            <fengxiang>西南风</fengxiang>
            <fengli><![CDATA[<3级]]></fengli>
            </day>
                <night>
                    <type>小雨</type>
                    <fengxiang>南风</fengxiang>
                    <fengli><![CDATA[<3级]]></fengli>
                </night>
        </weather>
        <weather>
            <date>17日星期四</date>
            <high>高温 14℃</high>
            <low>低温 7℃</low>
            <day>
                <type>小雨</type>
                <fengxiang>东南风</fengxiang>
                <fengli><![CDATA[<3级]]></fengli>
            </day>
            <night>
                <type>多云</type>
                <fengxiang>西北风</fengxiang>
                <fengli><![CDATA[<3级]]></fengli>
            </night>
        </weather>
        <weather>
        <date>18日星期五</date>
        <high>高温 17℃</high>
        <low>低温 8℃</low>
        <day>
        <type>多云</type>
        <fengxiang>西南风</fengxiang>
        <fengli><![CDATA[<3级]]></fengli>
        </day>
        <night>
        <type>多云</type>
        <fengxiang>北风</fengxiang>
        <fengli><![CDATA[<3级]]></fengli>
        </night>
        </weather>
        <weather>
            <date>19日星期六</date>
            <high>高温 20℃</high>
            <low>低温 10℃</low>
            <day>
                <type>多云</type>
                <fengxiang>南风</fengxiang>
                <fengli><![CDATA[<3级]]></fengli>
            </day>
            <night>
                <type>多云</type>
                <fengxiang>北风</fengxiang>
                <fengli><![CDATA[<3级]]></fengli>
            </night>
        </weather>
        <weather>
            <date>20日星期天</date>
            <high>高温 22℃</high>
            <low>低温 7℃</low>
            <day>
                <type>多云</type>
                <fengxiang>西北风</fengxiang>
                <fengli><![CDATA[3-4级]]></fengli>
            </day>
            <night>
                <type>晴</type>
                <fengxiang>北风</fengxiang>
                <fengli><![CDATA[<3级]]></fengli>
            </night>
        </weather>
    </forecast>
    <zhishus>
        <zhishu>
            <name>晨练指数</name>
            <value>较适宜</value>
            <detail>早晨气象条件较适宜晨练，但阴天导致树林夜晚释放的二氧化碳气体不易扩散，请避免在林中晨练。</detail></zhishu><zhishu><name>舒适度</name><value>较舒适</value><detail>白天天气阴沉，会感到有点儿凉，但大部分人完全可以接受。</detail></zhishu><zhishu><name>穿衣指数</name><value>较冷</value><detail>建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。</detail>
        </zhishu>
        <zhishu>
            <name>感冒指数</name>
            <value>较易发</value>
            <detail>天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。</detail>
        </zhishu>
        <zhishu>
            <name>晾晒指数</name>
            <value>不太适宜</value>
            <detail>天气阴沉，不利于水分的迅速蒸发，不太适宜晾晒。若需要晾晒，请尽量选择通风的地点。</detail></zhishu><zhishu><name>旅游指数</name><value>适宜</value><detail>天气较好，温度适宜，总体来说还是好天气哦，这样的天气适宜旅游，您可以尽情地享受大自然的风光。 </detail>
        </zhishu>
        <zhishu>
            <name>紫外线强度</name>
            <value>最弱</value>
            <detail>属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。</detail>
        </zhishu>
        <zhishu>
            <name>洗车指数</name>
            <value>不宜</value><detail>不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。</detail>
        </zhishu>
        <zhishu>
            <name>运动指数</name>
            <value>较适宜</value>
            <detail>阴天，较适宜进行各种户内外运动。</detail>
        </zhishu>
        <zhishu>
            <name>约会指数</name>
            <value>较适宜</value>
            <detail>虽然天空有些阴沉，但情侣们可以放心外出，不用担心天气来调皮捣乱而影响了兴致。</detail>
        </zhishu>
        <zhishu>
            <name>雨伞指数</name>
            <value>不带伞</value>
            <detail>阴天，但降水概率很低，因此您在出门的时候无须带雨伞。</detail>
        </zhishu>
    </zhishus>
</resp><!-- 10.42.121.88(10.42.121.88):8603 ; 10.42.161.121:8080 -->
```



## 二、java简单爬虫

### 1、请求获取链接

### 1.1  URL.openConnection()

&emsp;&emsp;返回一个URLConnection对象，他表示URL所引用的远程对象的链接。

### 1.2 URL.openStream()

&emsp;&emsp;返回URL链接读入的输入流，打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream

可能形式为：openConnection().getInputStream()

### 2、获取数据

#### 2.1 获取网页、文字

```java
StringBuffer sb = new StringBuffer("");
URL url;
try {
        url = new URL(targetUrl);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
        String s = "";
        while ((s = br.readLine()) != null) {
            i++;					
            sb.append(s + "\r\n");
        }
	} catch (Exception e) {
		e.printStackTrace();
	}
System.out.println(sb.toString());	
```



#### 2.2 获取文件

##### 2.2.1 保存文件的格式

&emsp;&emsp;打开谷歌的开发者工具，进入network选项，并在地址栏输入所需网址便可查找到如下图：

![获取请求文件编码](..\images\5-获取请求文件编码.png)

##### 2.2.2 保存文件

```java
URL url;
url = new URL(targetUrl);
File gzipFile = new File("weather.gzip");
FileOutputStream fos = new FileOutputStream(gzipFile );
DataInputStream	dis = new DataInputStream(url.openStream());
byte[]bytes = new byte[1024];
int length = 0;
while((length = dis.read(bytes,0,bytes.length)) != -1) {
	fos.write(bytes,0,length);
	fos.flush();
}
fos.close(); 
//解压并删除该文件
GZipUtils.decompress(gzipFile , true);
fixedFileName("weatherip","weather.json");
return new File("weather.json");
```

## 三、Json互转xml

#### 1、Json转为xml

导入GSON包,google开发的已知最为方便的Json解析包。

```xml
	<dependency>
		    <groupId>de.gerdi-project</groupId>
		    <artifactId>GSON</artifactId>
		    <version>6.0.5</version>
	</dependency>
```

解析Json包生成xml

```java
/**
jsonElement  json的元素
parentElement XML的父节点
name 名字
*/
public static Element toXml(JsonElement jsonElement,Element parentElement,String name) {
    	//该json元素为数组 便依次遍历
		if(jsonElement instanceof JsonArray) {
			JsonArray sonJsonArray = (JsonArray)jsonElement;
			for(int i =0;i<sonJsonArray.size();i++) {
				JsonElement arrayElement = sonJsonArray.get(i);
                //递归进行遍历
				toXml(arrayElement,parentElement,name);
			}
        //该json元素为单独对象，则加入xml
		}else if(jsonElement instanceof JsonObject) {
			JsonObject sonJsonObject = (JsonObject) jsonElement;
			Element currentElement = null;
			if(name != null) {
				currentElement = parentElement.addElement(name);
			}
			Set<Entry<String,JsonElement>> set = sonJsonObject.entrySet();
			for(Entry<String,JsonElement> s: set) {
				toXml(s.getValue(),currentElement!=null?currentElement:parentElement,s.getKey());
			}
		}else {
			addAttribute(parentElement,name,jsonElement.getAsString());
		}
		return parentElement;
	}
	public static void addAttribute(Element element, String name, String value) {
		//增加子节点，并为子节点赋值
		Element el = element.addElement(name);
		el.addText(value);
	}
```



#### 2、xml转Json

&emsp;&emsp;xml转Json较为简单，XML的静态方法支持转化。

```java
public static String xmljsonString() throws JSONException, IOException {
        InputStream in = XmlToJson.class.getResourceAsStream("test.xml");
        String xml = IOUtils.toString(in);
        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        return xmlJSONObj.toString();
    }

```





# Xml + Xsl 生成HTML

&emsp;&emsp;说实话这个真的不太懂,网上看着示例大概琢磨一些就是这样，基本html标签可以直接卸载xsl上。只能说大概会用一点点吧！！！最后这个作业也不能算完成，因为这是在本地分开运行的，加载在tomcat环境之后就不行了，生成的文件都不知道去哪了，这大概涉及到什么tomcat的运行机制了啦！！！小白表示难以攻克，以后加油啦！！！

```xml
<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" version="1.0" encoding="utf-8" standalone="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>XMl+XSL生成天气预报页面</title>
            </head>
            <body>
               
                天气：<xsl:value-of select="root/data/yesterday/type"/><br/>
      
                <div class="search-reasult">
                    <xsl:apply-templates select="root"/>
                </div>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="data">
        <br/>
        <br/>
        城市：<xsl:value-of select="./city"/><br/>
        <xsl:apply-templates select="./yesterday"/><br/>
        <xsl:apply-templates select="./forecast"/><br/>
        提示：<xsl:value-of select="./ganmao"/><br/>
        温度：<xsl:value-of select="./wendu"/><br/>
    </xsl:template>
    <xsl:template match="data/yesterday">
        <br/>
        <br/>
        日期：<xsl:value-of select="./date"/><br/>
        高温：<xsl:value-of select="./high"/><br/>
        低温：<xsl:value-of select="./low"/><br/>
        风向：<xsl:value-of select="./fx"/><br/>
        风力：<xsl:value-of select="./fl"/><br/>
        天气：<xsl:value-of select="./type"/><br/>
    </xsl:template>
    <xsl:template match="data/forecast">
        <br/>
        日期：<xsl:value-of select="./date"/><br/>
        高温：<xsl:value-of select="./high"/><br/>
        低温：<xsl:value-of select="./low"/><br/>
        风向：<xsl:value-of select="./fengxiang"/><br/>
        风力：<xsl:value-of select="./fengli"/><br/>
        天气：<xsl:value-of select="./type"/><br/>
    </xsl:template>
</xsl:stylesheet>
```



```java
  public static  void TransformOperate()throws IOException {	
        String xmlFileName = "F:/java/CourseDemo/5-WeatherAndXml/weather.xml";
        String xslFileName = "F:/java/CourseDemo/5-WeatherAndXml/src/main/resources/weather.xsl";
        String htmlFileName = "F:/java/CourseDemo/5-WeatherAndXml/src/main/webapp/search.html";
        System.out.println("TransformOperate()");
        Train.Transform(xmlFileName, xslFileName, htmlFileName);
    }
    public static void Transform(String xmlFileName, String xslFileName,
            String htmlFileName) {
        try {
            TransformerFactory tFac = TransformerFactory.newInstance();
            Source xslSource = new StreamSource(xslFileName);
            Transformer t = tFac.newTransformer(xslSource);
            File xmlFile = new File(xmlFileName);
            File htmlFile = new File(htmlFileName);
            Source source = new StreamSource(xmlFile);
            Result result = new StreamResult(htmlFile);
            t.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
```

效果图首页：

![](..\images\5-天气查询首页.png)

**效果图结果页**

![](..\images\5-天气查询结果页.png)

