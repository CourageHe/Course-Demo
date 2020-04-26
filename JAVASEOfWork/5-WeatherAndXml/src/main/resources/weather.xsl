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