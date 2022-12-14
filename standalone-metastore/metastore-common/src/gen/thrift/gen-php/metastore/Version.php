<?php
namespace metastore;

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

class Version
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'version',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
        2 => array(
            'var' => 'comments',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
    );

    /**
     * @var string
     */
    public $version = null;
    /**
     * @var string
     */
    public $comments = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['version'])) {
                $this->version = $vals['version'];
            }
            if (isset($vals['comments'])) {
                $this->comments = $vals['comments'];
            }
        }
    }

    public function getName()
    {
        return 'Version';
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
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->version);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->comments);
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
        $xfer += $output->writeStructBegin('Version');
        if ($this->version !== null) {
            $xfer += $output->writeFieldBegin('version', TType::STRING, 1);
            $xfer += $output->writeString($this->version);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->comments !== null) {
            $xfer += $output->writeFieldBegin('comments', TType::STRING, 2);
            $xfer += $output->writeString($this->comments);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
