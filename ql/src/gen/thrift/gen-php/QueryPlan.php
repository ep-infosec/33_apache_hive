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

class QueryPlan
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'queries',
            'isRequired' => false,
            'type' => TType::LST,
            'etype' => TType::STRUCT,
            'elem' => array(
                'type' => TType::STRUCT,
                'class' => '\Query',
                ),
        ),
        2 => array(
            'var' => 'done',
            'isRequired' => false,
            'type' => TType::BOOL,
        ),
        3 => array(
            'var' => 'started',
            'isRequired' => false,
            'type' => TType::BOOL,
        ),
    );

    /**
     * @var \Query[]
     */
    public $queries = null;
    /**
     * @var bool
     */
    public $done = null;
    /**
     * @var bool
     */
    public $started = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['queries'])) {
                $this->queries = $vals['queries'];
            }
            if (isset($vals['done'])) {
                $this->done = $vals['done'];
            }
            if (isset($vals['started'])) {
                $this->started = $vals['started'];
            }
        }
    }

    public function getName()
    {
        return 'QueryPlan';
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
                    if ($ftype == TType::LST) {
                        $this->queries = array();
                        $_size114 = 0;
                        $_etype117 = 0;
                        $xfer += $input->readListBegin($_etype117, $_size114);
                        for ($_i118 = 0; $_i118 < $_size114; ++$_i118) {
                            $elem119 = null;
                            $elem119 = new \Query();
                            $xfer += $elem119->read($input);
                            $this->queries []= $elem119;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::BOOL) {
                        $xfer += $input->readBool($this->done);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 3:
                    if ($ftype == TType::BOOL) {
                        $xfer += $input->readBool($this->started);
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
        $xfer += $output->writeStructBegin('QueryPlan');
        if ($this->queries !== null) {
            if (!is_array($this->queries)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('queries', TType::LST, 1);
            $output->writeListBegin(TType::STRUCT, count($this->queries));
            foreach ($this->queries as $iter120) {
                $xfer += $iter120->write($output);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        if ($this->done !== null) {
            $xfer += $output->writeFieldBegin('done', TType::BOOL, 2);
            $xfer += $output->writeBool($this->done);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->started !== null) {
            $xfer += $output->writeFieldBegin('started', TType::BOOL, 3);
            $xfer += $output->writeBool($this->started);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
