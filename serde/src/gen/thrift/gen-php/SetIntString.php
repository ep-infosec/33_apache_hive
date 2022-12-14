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

class SetIntString
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'sIntString',
            'isRequired' => false,
            'type' => TType::SET,
            'etype' => TType::STRUCT,
            'elem' => array(
                'type' => TType::STRUCT,
                'class' => '\IntString',
                ),
        ),
        2 => array(
            'var' => 'aString',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
    );

    /**
     * @var \IntString[]
     */
    public $sIntString = null;
    /**
     * @var string
     */
    public $aString = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['sIntString'])) {
                $this->sIntString = $vals['sIntString'];
            }
            if (isset($vals['aString'])) {
                $this->aString = $vals['aString'];
            }
        }
    }

    public function getName()
    {
        return 'SetIntString';
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
                    if ($ftype == TType::SET) {
                        $this->sIntString = array();
                        $_size73 = 0;
                        $_etype76 = 0;
                        $xfer += $input->readSetBegin($_etype76, $_size73);
                        for ($_i77 = 0; $_i77 < $_size73; ++$_i77) {
                            $elem78 = null;
                            $elem78 = new \IntString();
                            $xfer += $elem78->read($input);
                            $this->sIntString[] = $elem78;
                        }
                        $xfer += $input->readSetEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->aString);
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
        $xfer += $output->writeStructBegin('SetIntString');
        if ($this->sIntString !== null) {
            if (!is_array($this->sIntString)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('sIntString', TType::SET, 1);
            $output->writeSetBegin(TType::STRUCT, count($this->sIntString));
            foreach ($this->sIntString as $iter79 => $iter80) {
                $xfer += $iter80->write($output);
            }
            $output->writeSetEnd();
            $xfer += $output->writeFieldEnd();
        }
        if ($this->aString !== null) {
            $xfer += $output->writeFieldBegin('aString', TType::STRING, 2);
            $xfer += $output->writeString($this->aString);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
