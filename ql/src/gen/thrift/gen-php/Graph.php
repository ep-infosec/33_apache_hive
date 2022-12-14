<?php
/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
use Thrift\Base\TBase;
use Thrift\Type\TType;
use Thrift\Type\TMessageType;
use Thrift\Exception\TException;
use Thrift\Exception\TProtocolException;
use Thrift\Protocol\TProtocol;
use Thrift\Protocol\TBinaryProtocolAccelerated;
use Thrift\Exception\TApplicationException;

class Graph
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'nodeType',
            'isRequired' => false,
            'type' => TType::I32,
            'class' => '\NodeType',
        ),
        2 => array(
            'var' => 'roots',
            'isRequired' => false,
            'type' => TType::LST,
            'etype' => TType::STRING,
            'elem' => array(
                'type' => TType::STRING,
                ),
        ),
        3 => array(
            'var' => 'adjacencyList',
            'isRequired' => false,
            'type' => TType::LST,
            'etype' => TType::STRUCT,
            'elem' => array(
                'type' => TType::STRUCT,
                'class' => '\Adjacency',
                ),
        ),
    );

    /**
     * @var int
     */
    public $nodeType = null;
    /**
     * @var string[]
     */
    public $roots = null;
    /**
     * @var \Adjacency[]
     */
    public $adjacencyList = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['nodeType'])) {
                $this->nodeType = $vals['nodeType'];
            }
            if (isset($vals['roots'])) {
                $this->roots = $vals['roots'];
            }
            if (isset($vals['adjacencyList'])) {
                $this->adjacencyList = $vals['adjacencyList'];
            }
        }
    }

    public function getName()
    {
        return 'Graph';
    }


    public function read($input)
    {
        $xfer = 0;
        $fname = null;
        $ftype = 0;
        $fid = 0;
        $xfer += $input->readStructBegin($fname);
        while (true) {
            $xfer += $input->readFieldBegin($fname, $ftype, $fid);
            if ($ftype == TType::STOP) {
                break;
            }
            switch ($fid) {
                case 1:
                    if ($ftype == TType::I32) {
                        $xfer += $input->readI32($this->nodeType);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::LST) {
                        $this->roots = array();
                        $_size7 = 0;
                        $_etype10 = 0;
                        $xfer += $input->readListBegin($_etype10, $_size7);
                        for ($_i11 = 0; $_i11 < $_size7; ++$_i11) {
                            $elem12 = null;
                            $xfer += $input->readString($elem12);
                            $this->roots []= $elem12;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 3:
                    if ($ftype == TType::LST) {
                        $this->adjacencyList = array();
                        $_size13 = 0;
                        $_etype16 = 0;
                        $xfer += $input->readListBegin($_etype16, $_size13);
                        for ($_i17 = 0; $_i17 < $_size13; ++$_i17) {
                            $elem18 = null;
                            $elem18 = new \Adjacency();
                            $xfer += $elem18->read($input);
                            $this->adjacencyList []= $elem18;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                default:
                    $xfer += $input->skip($ftype);
                    break;
            }
            $xfer += $input->readFieldEnd();
        }
        $xfer += $input->readStructEnd();
        return $xfer;
    }

    public function write($output)
    {
        $xfer = 0;
        $xfer += $output->writeStructBegin('Graph');
        if ($this->nodeType !== null) {
            $xfer += $output->writeFieldBegin('nodeType', TType::I32, 1);
            $xfer += $output->writeI32($this->nodeType);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->roots !== null) {
            if (!is_array($this->roots)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('roots', TType::LST, 2);
            $output->writeListBegin(TType::STRING, count($this->roots));
            foreach ($this->roots as $iter19) {
                $xfer += $output->writeString($iter19);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        if ($this->adjacencyList !== null) {
            if (!is_array($this->adjacencyList)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('adjacencyList', TType::LST, 3);
            $output->writeListBegin(TType::STRUCT, count($this->adjacencyList));
            foreach ($this->adjacencyList as $iter20) {
                $xfer += $iter20->write($output);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
