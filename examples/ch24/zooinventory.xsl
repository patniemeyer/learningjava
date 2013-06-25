<xsl:stylesheet	
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:template match="/inventory">
		<html><head><title>Zoo Inventory</title></head>
		<body><h1>Zoo Inventory</h1>
		<table border="1">
		<tr><td><b>Name</b></td><td><b>Species</b></td>
		<td><b>Habitat</b></td><td><b>Temperament</b></td>
		<td><b>Diet</b></td></tr>
			<xsl:apply-templates/><!-- Process Inventory -->
		</table>
		</body>
		</html>
	</xsl:template>
	<xsl:template match="inventory/animal">
			<tr><td><xsl:value-of select="name"/></td>
		    <td><xsl:value-of select="species"/></td>
			<td><xsl:value-of select="habitat"/></td>
			<td><xsl:value-of select="temperament"/></td> 
			<td><xsl:apply-templates select="food|foodRecipe"/>
				<!-- Process Food,FoodRecipe--></td></tr>
	</xsl:template>

	<xsl:template match="foodRecipe">
		<table>
		<tr><td><em><xsl:value-of select="name"/></em></td></tr>
		<xsl:for-each select="ingredient">
			<tr><td><xsl:value-of select="."/></td></tr>
		</xsl:for-each>
		</table>
	</xsl:template>

</xsl:stylesheet>
