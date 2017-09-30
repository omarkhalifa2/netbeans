/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.xml.wsdl.model.impl;

import java.util.Collection;
import org.netbeans.modules.xml.wsdl.model.Port;
import org.netbeans.modules.xml.wsdl.model.Service;
import org.netbeans.modules.xml.wsdl.model.WSDLModel;
import org.netbeans.modules.xml.wsdl.model.visitor.WSDLVisitor;
import org.w3c.dom.Element;

/**
 *
 * @author Nam Nguyen
 */
public class ServiceImpl extends NamedImpl implements Service {
    
    /** Creates a new instance of ServiceImple */
    public ServiceImpl(WSDLModel model, Element e) {
        super(model, e);
    }
    
    public ServiceImpl(WSDLModel model){
        this(model, createNewElement(WSDLQNames.SERVICE.getQName(), model));
    }

    public void removePort(Port port) {
        removeChild(PORT_PROPERTY, port);
    }

    public void addPort(Port port) {
        super.addAfter(PORT_PROPERTY, port, TypeCollection.DOCUMENTATION.types());
    }

    public Collection<Port> getPorts() {
        return getChildren(Port.class);
    }

    public void accept(WSDLVisitor visitor) {
        visitor.visit(this);
    }
}