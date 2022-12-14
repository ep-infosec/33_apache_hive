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

final class LockType
{
    const SHARED_READ = 1;

    const SHARED_WRITE = 2;

    const EXCLUSIVE = 3;

    const EXCL_WRITE = 4;

    static public $__names = array(
        1 => 'SHARED_READ',
        2 => 'SHARED_WRITE',
        3 => 'EXCLUSIVE',
        4 => 'EXCL_WRITE',
    );
}

