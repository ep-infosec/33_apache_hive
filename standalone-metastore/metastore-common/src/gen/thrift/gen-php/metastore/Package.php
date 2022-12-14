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

class Package
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'catName',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
        2 => array(
            'var' => 'dbName',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
        3 => array(
            'var' => 'packageName',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
        4 => array(
            'var' => 'ownerName',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
        5 => array(
            'var' => 'header',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
        6 => array(
            'var' => 'body',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
    );

    /**
     * @var string
     */
    public $catName = null;
    /**
     * @var string
     */
    public $dbName = null;
    /**
     * @var string
     */
    public $packageName = null;
    /**
     * @var string
     */
    public $ownerName = null;
    /**
     * @var string
     */
    public $header = null;
    /**
     * @var string
     */
    public $body = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['catName'])) {
                $this->catName = $vals['catName'];
            }
            if (isset($vals['dbName'])) {
                $this->dbName = $vals['dbName'];
            }
            if (isset($vals['packageName'])) {
                $this->packageName = $vals['packageName'];
            }
            if (isset($vals['ownerName'])) {
                $this->ownerName = $vals['ownerName'];
            }
            if (isset($vals['header'])) {
                $this->header = $vals['header'];
            }
            if (isset($vals['body'])) {
                $this->body = $vals['body'];
            }
        }
    }

    public function getName()
    {
        return 'Package';
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
                        $xfer += $input->readString($this->catName);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->dbName);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 3:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->packageName);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 4:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->ownerName);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 5:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->header);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 6:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->body);
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
        $xfer += $output->writeStructBegin('Package');
        if ($this->catName !== null) {
            $xfer += $output->writeFieldBegin('catName', TType::STRING, 1);
            $xfer += $output->writeString($this->catName);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->dbName !== null) {
            $xfer += $output->writeFieldBegin('dbName', TType::STRING, 2);
            $xfer += $output->writeString($this->dbName);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->packageName !== null) {
            $xfer += $output->writeFieldBegin('packageName', TType::STRING, 3);
            $xfer += $output->writeString($this->packageName);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->ownerName !== null) {
            $xfer += $output->writeFieldBegin('ownerName', TType::STRING, 4);
            $xfer += $output->writeString($this->ownerName);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->header !== null) {
            $xfer += $output->writeFieldBegin('header', TType::STRING, 5);
            $xfer += $output->writeString($this->header);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->body !== null) {
            $xfer += $output->writeFieldBegin('body', TType::STRING, 6);
            $xfer += $output->writeString($this->body);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
