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

final class WMResourcePlanStatus
{
    const ACTIVE = 1;

    const ENABLED = 2;

    const DISABLED = 3;

    static public $__names = array(
        1 => 'ACTIVE',
        2 => 'ENABLED',
        3 => 'DISABLED',
    );
}

