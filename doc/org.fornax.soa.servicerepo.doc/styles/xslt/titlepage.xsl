<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:exsl="http://exslt.org/common" version="1.0" exclude-result-prefixes="exsl">
  <xsl:template name="article.titlepage.separator">
    <fo:block xmlns:fo="http://www.w3.org/1999/XSL/Format" space-after.minimum="25pt" space-after.maximum="25pt"/>
  </xsl:template>
   <xsl:template name="book.titlepage.recto">
        <fo:block>
            <fo:table table-layout="fixed" width="175mm">
                <fo:table-column column-width="175mm"/>
                <fo:table-body>
                    <fo:table-row height="20pc">
                        <fo:table-cell text-align="center">
                            <fo:block> </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    <fo:table-row>
                        <fo:table-cell text-align="center">
                            <fo:block>
                                <fo:external-graphic src="file:src/5.0/content/images/logo/Xpand-logo.png" content-width="10cm"/>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    <fo:table-row>
                        <fo:table-cell text-align="center">
                            <fo:block font-family="Helvetica" font-size="24pt" padding-before="25mm">
                                <xsl:value-of select="title"/> 
                            </fo:block>
                            <fo:block font-family="Helvetica" font-size="12pt">
                                <!-- <xsl:value-of select="bookinfo/releaseinfo"/> -->
                                <xsl:text>Sven Efftinge, Peter Friese, Arno Hase, Dennis Hübner, Clemens Kadura, Bernd Kolb, Jan Köhnlein, 
                                Dieter Moroff, Karsten Thoms, Markus Völter, Patrick Schönbach, Moritz Eysholdt, Steven Reinisch, Darius Jockel, Andre Arnold and contributors</xsl:text>
                            </fo:block>
                            <fo:block font-family="Helvetica" font-size="12pt" padding="10mm">
                                <xsl:text>Copyright 2004 - 2010</xsl:text>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>
        </fo:block>
    </xsl:template>
  
</xsl:stylesheet>