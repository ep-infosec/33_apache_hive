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

final class LockState
{
    const ACQUIRED = 1;

    const WAITING = 2;

    const ABORT = 3;

    const NOT_ACQUIRED = 4;

    static public $__names = array(
        1 => 'ACQUIRED',
        2 => 'WAITING',
        3 => 'ABORT',
        4 => 'NOT_ACQUIRED',
    );
}

