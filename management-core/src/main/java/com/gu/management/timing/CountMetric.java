/*
 * Copyright 2010 Guardian News and Media
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.gu.management.timing;

import com.gu.management.status.StatusWriter;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.util.concurrent.atomic.AtomicLong;

public class CountMetric extends StatusWriter {

	private AtomicLong count = new AtomicLong();
	private String managementStatusElementName;

	public long getCount() {
		return count.get();
	}

	public String getManagementStatusElementName() {
		return managementStatusElementName;
	}

	public void setManagementStatusElementName(String name) {
		this.managementStatusElementName = name;
	}

	@Override public void writeStatus(XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		xmlStreamWriter.writeStartElement(managementStatusElementName);
		xmlStreamWriter.writeCharacters(count.toString());
		xmlStreamWriter.writeEndElement();
    }

    public void recordCount(int count) {
        this.count.addAndGet(count);
    }
}