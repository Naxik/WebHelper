package ru.another.config.dozer;

import lombok.extern.slf4j.Slf4j;
import org.dozer.util.ResourceLoader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Another
 *         date: 16.08.2016.
 */
@Slf4j
public class DozerResolver implements EntityResolver {
	@Override
	public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
		log.debug("Trying to resolve XML entity with public ID [{}] and system ID [{}]", publicId, systemId);
		// First try to find it in the classpath
		if (systemId != null && !"".equals(systemId)) {
			String systemIdStripped = systemId;
			if (systemId.lastIndexOf("/") > 0) {
				systemIdStripped = systemId.substring(systemId.lastIndexOf("/"));
			}
			try {
				InputStream inputStream = DozerResolver.class.getResourceAsStream(systemIdStripped);
				if (inputStream != null) {
					return new InputSource(inputStream);
				}
			} catch (Exception e) {
				log.debug("not found in the classpath", e);
			}
		}

		if ((systemId != null) && (systemId.indexOf("beanmapping.xsd") > systemId.lastIndexOf("/"))) {
			String fileName = systemId.substring(systemId.indexOf("beanmapping.xsd"));
			log.debug("Trying to locate [{}] in classpath", fileName);
			try {
				ResourceLoader resourceLoader = new ResourceLoader(null);
				InputStream stream = resourceLoader.getResource(fileName).openStream();
				InputSource source = new InputSource(stream);
				source.setPublicId(publicId);
				source.setSystemId(systemId);
				log.debug("Found beanmapping XML Schema [{}] in classpath", systemId);
				return source;
			} catch (Exception ex) {
				log.error("Could not resolve beansmapping XML Schema [{}]: not found in classpath", systemId, ex);
			}
		}
		return null;
	}
}
