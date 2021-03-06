/*-
 * #%L
 * This file is part of QuPath.
 * %%
 * Copyright (C) 2014 - 2016 The Queen's University of Belfast, Northern Ireland
 * Contact: IP Management (ipmanagement@qub.ac.uk)
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

package qupath.lib.gui.commands;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import qupath.lib.gui.QuPathGUI;
import qupath.lib.gui.commands.interfaces.PathCommand;
import qupath.lib.gui.tools.GuiTools;

/**
 * Command to launch browser to view demo screencasts.
 * 
 * @author Pete Bankhead
 *
 */
public class OpenWebpageCommand implements PathCommand {
	
	final private static Logger logger = LoggerFactory.getLogger(OpenWebpageCommand.class);
	
	private QuPathGUI qupath;
	private URI uri;
	
	public OpenWebpageCommand(final QuPathGUI qupath, final String uri) {
		this.qupath = qupath;
		try {
			this.uri = new URI(uri);
		} catch (URISyntaxException e) {
			logger.error("Error constructing URI: " + uri, e);
		}
	}

	@Override
	public void run() {
		GuiTools.browseURI(uri);
	}

}
