/*
 *  Copyright  2004-2006 Stefan Reuter
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.asteriskjava.fastagi;

import java.net.InetAddress;
import java.util.Map;

import junit.framework.TestCase;

import org.asteriskjava.fastagi.AGIRequest;
import org.asteriskjava.fastagi.AGIScript;
import org.asteriskjava.fastagi.ClassNameMappingStrategy;

public class ClassNameMappingStrategyTest extends TestCase
{
    private ClassNameMappingStrategy mappingStrategy;

    protected void setUp() throws Exception
    {
        super.setUp();
        this.mappingStrategy = new ClassNameMappingStrategy();
    }

    public void testDetermineScript()
    {
        AGIScript scriptFirstPass;
        AGIScript scriptSecondPass;
        AGIRequest request;

        request = new SimpleAGIRequest();

        scriptFirstPass = mappingStrategy.determineScript(request);
        scriptSecondPass = mappingStrategy.determineScript(request);

        assertEquals("incorrect script determined",
                scriptFirstPass.getClass(), HelloAGIScript.class);

        assertTrue("script instances are not cached",
                scriptFirstPass == scriptSecondPass);
    }
    
    public class SimpleAGIRequest implements AGIRequest
    {
        private InetAddress localAddress;
        private int localPort;
        private InetAddress remoteAddress;
        private int remotePort;

        public Map getRequest()
        {
            throw new UnsupportedOperationException();
        }

        public String getScript()
        {
            return "org.asteriskjava.fastagi.HelloAGIScript";
        }

        public String getRequestURL()
        {
            throw new UnsupportedOperationException();
        }

        public String getChannel()
        {
            throw new UnsupportedOperationException();
        }

        public String getUniqueId()
        {
            throw new UnsupportedOperationException();
        }

        public String getType()
        {
            throw new UnsupportedOperationException();
        }

        public String getLanguage()
        {
            throw new UnsupportedOperationException();
        }

        public String getCallerId()
        {
            throw new UnsupportedOperationException();
        }

        public String getCallerIdName()
        {
            throw new UnsupportedOperationException();
        }

        public String getDnid()
        {
            throw new UnsupportedOperationException();
        }

        public String getRdnis()
        {
            throw new UnsupportedOperationException();
        }

        public String getContext()
        {
            throw new UnsupportedOperationException();
        }

        public String getExtension()
        {
            throw new UnsupportedOperationException();
        }

        public Integer getPriority()
        {
            throw new UnsupportedOperationException();
        }

        public Boolean getEnhanced()
        {
            throw new UnsupportedOperationException();
        }

        public String getAccountCode()
        {
            throw new UnsupportedOperationException();
        }

        public Integer getCallingAni2()
        {
            throw new UnsupportedOperationException();
        }

        public Integer getCallingPres()
        {
            throw new UnsupportedOperationException();
        }

        public Integer getCallingTns()
        {
            throw new UnsupportedOperationException();
        }

        public Integer getCallingTon()
        {
            throw new UnsupportedOperationException();
        }

        public String getParameter(String name)
        {
            throw new UnsupportedOperationException();
        }

        public String[] getParameterValues(String name)
        {
            throw new UnsupportedOperationException();
        }

        public Map getParameterMap()
        {
            throw new UnsupportedOperationException();
        }

        public InetAddress getLocalAddress()
        {
            return localAddress;
        }

        public void setLocalAddress(InetAddress localAddress)
        {
            this.localAddress = localAddress;
        }

        public int getLocalPort()
        {
            return localPort;
        }

        public void setLocalPort(int localPort)
        {
            this.localPort = localPort;
        }

        public InetAddress getRemoteAddress()
        {
            return remoteAddress;
        }

        public void setRemoteAddress(InetAddress remoteAddress)
        {
            this.remoteAddress = remoteAddress;
        }

        public int getRemotePort()
        {
            return remotePort;
        }

        public void setRemotePort(int remotePort)
        {
            this.remotePort = remotePort;
        }
    }
}
