<?xml version="1.0" encoding="UTF-8"?>
<Devices>
    <motherBoard id="1" name="MB_A1">
        <manufacturer>Asus</manufacturer>
        <type>PROFESSIONAL</type>
        <connfiguration>ATX</connfiguration>
        <Processor id="2">
            <name>F8300</name>
            <manufacturer>Intel</manufacturer>
            <frequencyCore>2100</frequencyCore>
            <coresNumber>4</coresNumber>
            <processorType>CPU</processorType>
        </Processor>
    </motherBoard>
    <videoCard id="3" name="MB_A1">
        <manufacturer>Asus</manufacturer>
        <type>GAMING</type>
        <memoryRAM>4</memoryRAM>
        <Processor id="4">
            <name>F04</name>
            <manufacturer>NVIDIA</manufacturer>
            <frequencyCore>2100</frequencyCore>
            <coresNumber>4</coresNumber>
            <processorType>GPU</processorType>
        </Processor>
    </videoCard>
    <motherBoard id="5" name="ZEN_A1">
        <manufacturer>GIGABYTE</manufacturer>
        <type>GAMING</type>
        <connfiguration>MATX</connfiguration>
        <Processor id="6">
            <name>K5400</name>
            <manufacturer>Intel</manufacturer>
            <frequencyCore>2100</frequencyCore>
            <coresNumber>4</coresNumber>
            <processorType>CPU</processorType>
        </Processor>
    </motherBoard>
    <videoCard id="7" name="VEGA">
        <manufacturer>AMD</manufacturer>
        <type>PROFESSIONAL</type>
        <memoryRAM>16</memoryRAM>
        <Processor id="8">
            <name>F04</name>
            <manufacturer>AMD</manufacturer>
            <frequencyCore>2100</frequencyCore>
            <coresNumber>4</coresNumber>
            <processorType>GPU</processorType>
        </Processor>
    </videoCard>
    <processor id="5" name="FX8300">
        <manufacturer>AMD</manufacturer>
        <frequencyCore>2100</frequencyCore>
        <coresNumber>4</coresNumber>
        <processorType>CPU</processorType>
    </processor>
    <processor id="2" name="Ryzen3500">
        <manufacturer>AMD</manufacturer>
        <frequencyCore>2100</frequencyCore>
        <coresNumber>8</coresNumber>
        <processorType>CPU</processorType>
    </processor>
</Devices>







<?xml version="1.0" encoding="UTF-8"?>
<schema>
    <element name="Devices">
        <complexType>
            <all>
                <elemnet name="motherBoard" type="tns:MotherBoard"
                         minOccurs="2"
                         maxOccurs="unbonded"/>
                <elemnet name="videoCard" type="tns:VideoCard"
                         minOccurs="2"
                         maxOccurs="unbonded"/>
                <elemnet name="processor" type="tns:Processor"
                         minOccurs="2"
                         maxOccurs="unbonded"/>
            </all>
        </complexType>
    </element>
    <complexType name="AbstractComputerParts">
        <atribute name="id" type="int" use="required"/>
        <atribute name="name" type="string" use="otional" default="N/A"/>
        <sequence>
            <element name="manufacturer" type="string"/>
        </sequence>
    </complexType>
    <complexType name="Processor">
        <complexContent>
            <extension base="tns:AbstractComputerParts">
                <sequence>
                    <element name="frequencyCore" type="string"/>
                    <element name="coresNumber" type="int"
                             minOccurs="2"
                             maxOccurs="12"/>
                    <element name="processorType">
                        <simplyTipe>
                            <restriction base="string">
                                <enumaration value="GPU"></enumaration>
                                <enumaration value="CPU"></enumaration>
                            </restriction>
                        </simplyTipe>
                    </element>
                </sequence>
            </extension>
        </complexContent>
    </complexType>
    <complexType name="Board">
        <complexContent>
            <extension base="tns:AbstractComputerParts">
                <sequence>
                    <element name="type">
                        <siplyTipe>
                            <restriction base="string">
                                <enumaration value="GAMING"></enumaration>
                                <enumaration value="PROFESSIONAL"></enumaration>
                            </restriction>
                        </siplyTipe>
                    </element>
                </sequence>
            </extension>
        </complexContent>
    </complexType>
    <complexType name="MotherBoard">
        <complexContent>
            <extension base="tns:Board">
                <sequence>
                    <element name="configuration">
                        <siplyTipe>
                            <restriction base="string">
                                <enumaration value="EATX"></enumaration>
                                <enumaration value="MATX"></enumaration>
                                <enumaration value="ATX"></enumaration>
                            </restriction>
                        </siplyTipe>
                    </element>
                </sequence>
            </extension>
        </complexContent>
    </complexType>
    <complexType name="VideoCard">
        <complexContent>
            <extension base="tns:Board">
                <sequence>
                    <element name="memoryRAM" type="string"/>
                    <element name="processor" type="tns:Processor"/>
                </sequence>
            </extension>
        </complexContent>
    </complexType>
</schema>
