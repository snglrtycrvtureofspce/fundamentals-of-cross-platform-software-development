<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html>
      <head>
        <title>Лекарственные препараты</title>
      </head>
      <body>
        <h1>Информация о лекарственных препаратах</h1>
        <table border="1">
          <tr>
            <th>Name</th>
            <th>Pharm</th>
            <th>Group</th>
            <th>Analogs</th>
            <th>Versions</th>
          </tr>
          <xsl:for-each select="Medicine">
            <tr>
              <td><xsl:value-of select="Name"/></td>
              <td><xsl:value-of select="Pharm"/></td>
              <td><xsl:value-of select="Group"/></td>
              <td>
                <xsl:for-each select="Analogs/Analog">
                  <xsl:value-of select="."/><xsl:if test="position() != last()">, </xsl:if>
                </xsl:for-each>
              </td>
              <td>
                <xsl:for-each select="Versions/Version">
                  <xsl:value-of select="."/><xsl:if test="position() != last()">, </xsl:if>
                </xsl:for-each>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
