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

class TOpenSessionResp
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'status',
            'isRequired' => true,
            'type' => TType::STRUCT,
            'class' => '\TStatus',
        ),
        2 => array(
            'var' => 'serverProtocolVersion',
            'isRequired' => true,
            'type' => TType::I32,
            'class' => '\TProtocolVersion',
        ),
        3 => array(
            'var' => 'sessionHandle',
            'isRequired' => false,
            'type' => TType::STRUCT,
            'class' => '\TSessionHandle',
        ),
        4 => array(
            'var' => 'configuration',
            'isRequired' => false,
            'type' => TType::MAP,
            'ktype' => TType::STRING,
            'vtype' => TType::STRING,
            'key' => array(
                'type' => TType::STRING,
            ),
            'val' => array(
                'type' => TType::STRING,
                ),
        ),
    );

    /**
     * @var \TStatus
     */
    public $status = null;
    /**
     * @var int
     */
    public $serverProtocolVersion =     9;
    /**
     * @var \TSessionHandle
     */
    public $sessionHandle = null;
    /**
     * @var array
     */
    public $configuration = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['status'])) {
                $this->status = $vals['status'];
            }
            if (isset($vals['serverProtocolVersion'])) {
                $this->serverProtocolVersion = $vals['serverProtocolVersion'];
            }
            if (isset($vals['sessionHandle'])) {
                $this->sessionHandle = $vals['sessionHandle'];
            }
            if (isset($vals['configuration'])) {
                $this->configuration = $vals['configuration'];
            }
        }
    }

    public function getName()
    {
        return 'TOpenSessionResp';
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
                    if ($ftype == TType::STRUCT) {
                        $this->status = new \TStatus();
                        $xfer += $this->status->read($input);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::I32) {
                        $xfer += $input->readI32($this->serverProtocolVersion);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 3:
                    if ($ftype == TType::STRUCT) {
                        $this->sessionHandle = new \TSessionHandle();
                        $xfer += $this->sessionHandle->read($input);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 4:
                    if ($ftype == TType::MAP) {
                        $this->configuration = array();
                        $_size134 = 0;
                        $_ktype135 = 0;
                        $_vtype136 = 0;
                        $xfer += $input->readMapBegin($_ktype135, $_vtype136, $_size134);
                        for ($_i138 = 0; $_i138 < $_size134; ++$_i138) {
                            $key139 = '';
                            $val140 = '';
                            $xfer += $input->readString($key139);
                            $xfer += $input->readString($val140);
                            $this->configuration[$key139] = $val140;
                        }
                        $xfer += $input->readMapEnd();
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
        $xfer += $output->writeStructBegin('TOpenSessionResp');
        if ($this->status !== null) {
            if (!is_object($this->status)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('status', TType::STRUCT, 1);
            $xfer += $this->status->write($output);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->serverProtocolVersion !== null) {
            $xfer += $output->writeFieldBegin('serverProtocolVersion', TType::I32, 2);
            $xfer += $output->writeI32($this->serverProtocolVersion);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->sessionHandle !== null) {
            if (!is_object($this->sessionHandle)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('sessionHandle', TType::STRUCT, 3);
            $xfer += $this->sessionHandle->write($output);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->configuration !== null) {
            if (!is_array($this->configuration)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('configuration', TType::MAP, 4);
            $output->writeMapBegin(TType::STRING, TType::STRING, count($this->configuration));
            foreach ($this->configuration as $kiter141 => $viter142) {
                $xfer += $output->writeString($kiter141);
                $xfer += $output->writeString($viter142);
            }
            $output->writeMapEnd();
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
