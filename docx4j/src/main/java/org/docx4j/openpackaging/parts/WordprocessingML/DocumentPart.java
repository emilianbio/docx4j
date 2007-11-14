/*
 *  Copyright 2007, Plutext Pty Ltd.
 *   
 *  This file is part of Docx4J.

    Docx4J is free software: you can redistribute it and/or modify
    it under the terms of version 3 of the GNU General Public License 
    as published by the Free Software Foundation.

    Docx4J is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License   
    along with Docx4J.  If not, see <http://www.gnu.org/licenses/>.
    
 */

package org.docx4j.openpackaging.parts.WordprocessingML;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
//import java.net.URI;

import org.docx4j.Namespaces;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.exceptions.OpenXML4JException;
import org.docx4j.openpackaging.parts.DocPropsCorePart;
import org.docx4j.openpackaging.parts.DocPropsExtendedPart;
import org.docx4j.openpackaging.parts.Part;
import org.docx4j.openpackaging.parts.PartName;
import org.dom4j.Document;



public abstract class DocumentPart extends Part {
	
	/** Parts which can be the target of a relationship from either
	 *  the Main Document or the Glossary Document
	 *  
	 *  Microsoft's Microsoft.Office.DocumentFormat.OpenXML has
	 *  no equivalent of this.  
	 *  
	 */ 
	
	protected CommentsPart commentsPart; //done
	
	protected DocumentSettingsPart documentSettingsPart;
	
	protected EndnotesPart endNotesPart; //done
	
	protected FontTablePart fontTablePart; // done (ie setup below and in SchemaType_
	
	
	protected FootnotesPart footnotesPart; //done
	
	//protected List headerParts;
	//protected List footerParts;
	
	protected NumberingDefinitionsPart numberingDefinitionsPart; //done
	
	protected StyleDefinitionsPart styleDefinitionsPart; //done
	
	protected WebSettingsPart webSettingsPart; //done
	
	public boolean setPartShortcut(Part part, String relationshipType) {
		if (relationshipType.equals(Namespaces.FONT_TABLE)) {
			fontTablePart = (FontTablePart)part;
			return true;			
		} else if (relationshipType.equals(Namespaces.STYLES)) {
			styleDefinitionsPart = (StyleDefinitionsPart)part;
			return true;			
		} else if (relationshipType.equals(Namespaces.WEB_SETTINGS)) {
			webSettingsPart = (WebSettingsPart)part;
			return true;	
		} else if (relationshipType.equals(Namespaces.COMMENTS)) {
			commentsPart = (CommentsPart)part;
			return true;	
		} else if (relationshipType.equals(Namespaces.ENDNOTES)) {
			endNotesPart = (EndnotesPart)part;
			return true;	
		} else if (relationshipType.equals(Namespaces.FOOTNOTES)) {
			footnotesPart = (FootnotesPart)part;
			return true;	
		} else if (relationshipType.equals(Namespaces.NUMBERING)) {
			numberingDefinitionsPart = (NumberingDefinitionsPart)part;
			return true;	
			
			// TODO - to be completed.
		} else {	
			return false;
		}
	}
	
	
	/** Other characteristics which both the Main Document and the
	 *  Glossary Document have.
	 */ 
	//private VML background; // [1.2.1]
	
	//public DocumentPart(Package pack, PackagePartName partUri) {
	public DocumentPart() {
		// super(pack,partUri);		
	}
	
	public DocumentPart(PartName partName) throws InvalidFormatException {
		super(partName);
	}
	

	public CommentsPart getCommentsPart() {
		return commentsPart;
	}


	public DocumentSettingsPart getDocumentSettingsPart() {
		return documentSettingsPart;
	}


	public EndnotesPart getEndNotesPart() {
		return endNotesPart;
	}


	public FontTablePart getFontTablePart() {
		return fontTablePart;
	}


//	public List getFooterParts() {
//		return footerPart;
//	}


	public FootnotesPart getFootnotesPart() {
		return footnotesPart;
	}


//	public List getHeaderParts() {
//		return headerPart;
//	}


	public NumberingDefinitionsPart getNumberingDefinitionsPart() {
		return numberingDefinitionsPart;
	}


	public StyleDefinitionsPart getStyleDefinitionsPart() {
		return styleDefinitionsPart;
	}


	public WebSettingsPart getWebSettingsPart() {
		return webSettingsPart;
	}

	
}
