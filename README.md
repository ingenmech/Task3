# Task3

<?xml version="1.0" encoding="UTF-8"?>
<AbstarctComputerParts>
    <Boards>
        <MotherBoard id="1">
            <name>MB_A1</name>
            <manufacturer>Asus</manufacturer>
            <size>mini</size>
            <connectionInterfaces></connectionInterfaces>
            <Processor id="3">
                <name>F8300</name>
                <manufacturer>Intel</manufacturer>
                <frequencyCore>2100</frequencyCore>
                <processorType>CPU</processorType>
                <coresNumber>4</coresNumber>
            </Processor>
        </MotherBoard>
        <VideoCard id="2">
            <name>MB_A1</name>
            <manufacturer>Asus</manufacturer>
            <size>standart</size>
            <memoryRAM>4</memoryRAM>
            <Processor id="4">
                <name>P23</name>
                <manufacturer>Nvidia</manufacturer>
                <frequencyCore>800</frequencyCore>
                <processorType>VIDEO</processorType>
                <coresNumber>9</coresNumber>
            </Processor>
        </VideoCard>
    </Boards>
</AbstarctComputerParts>


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
            </all>
        </complexType>
    </element>

    <complexType name="AbstractComputerParts">
        <atribute name="id" type="int" use="required"/>
        <sequence>
            <element name="name" type="string"/>
            <element name="manufacturer" type="string"/>
        </sequence>
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

    <complexType name="Processor">
        <complexContent>
            <extension base="tns:AbstractComputerParts">
                <sequence>
                    <element name="frequencyCore" type="string"/>
                    <element name="processorType">
                        <simplyTipe>
                            <restriction base="string">
                                <enumaration value="VGA"></enumaration>
                                <enumaration value="CPU"></enumaration>
                            </restriction>
                        </simplyTipe>
                    </element>
                </sequence>
            </extension>
        </complexContent>
    </complexType>

</schema>
