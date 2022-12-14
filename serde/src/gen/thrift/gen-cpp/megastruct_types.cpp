/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#include "megastruct_types.h"

#include <algorithm>
#include <ostream>

#include <thrift/TToString.h>



int _kMyEnumValues[] = {
  MyEnum::LLAMA,
  MyEnum::ALPACA
};
const char* _kMyEnumNames[] = {
  "LLAMA",
  "ALPACA"
};
const std::map<int, const char*> _MyEnum_VALUES_TO_NAMES(::apache::thrift::TEnumIterator(2, _kMyEnumValues, _kMyEnumNames), ::apache::thrift::TEnumIterator(-1, nullptr, nullptr));

std::ostream& operator<<(std::ostream& out, const MyEnum::type& val) {
  std::map<int, const char*>::const_iterator it = _MyEnum_VALUES_TO_NAMES.find(val);
  if (it != _MyEnum_VALUES_TO_NAMES.end()) {
    out << it->second;
  } else {
    out << static_cast<int>(val);
  }
  return out;
}

std::string to_string(const MyEnum::type& val) {
  std::map<int, const char*>::const_iterator it = _MyEnum_VALUES_TO_NAMES.find(val);
  if (it != _MyEnum_VALUES_TO_NAMES.end()) {
    return std::string(it->second);
  } else {
    return std::to_string(static_cast<int>(val));
  }
}


MiniStruct::~MiniStruct() noexcept {
}


void MiniStruct::__set_my_string(const std::string& val) {
  this->my_string = val;
__isset.my_string = true;
}

void MiniStruct::__set_my_enum(const MyEnum::type val) {
  this->my_enum = val;
__isset.my_enum = true;
}
std::ostream& operator<<(std::ostream& out, const MiniStruct& obj)
{
  obj.printTo(out);
  return out;
}


uint32_t MiniStruct::read(::apache::thrift::protocol::TProtocol* iprot) {

  ::apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->my_string);
          this->__isset.my_string = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          int32_t ecast0;
          xfer += iprot->readI32(ecast0);
          this->my_enum = static_cast<MyEnum::type>(ecast0);
          this->__isset.my_enum = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t MiniStruct::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  ::apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("MiniStruct");

  if (this->__isset.my_string) {
    xfer += oprot->writeFieldBegin("my_string", ::apache::thrift::protocol::T_STRING, 1);
    xfer += oprot->writeString(this->my_string);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_enum) {
    xfer += oprot->writeFieldBegin("my_enum", ::apache::thrift::protocol::T_I32, 2);
    xfer += oprot->writeI32(static_cast<int32_t>(this->my_enum));
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(MiniStruct &a, MiniStruct &b) {
  using ::std::swap;
  swap(a.my_string, b.my_string);
  swap(a.my_enum, b.my_enum);
  swap(a.__isset, b.__isset);
}

MiniStruct::MiniStruct(const MiniStruct& other1) {
  my_string = other1.my_string;
  my_enum = other1.my_enum;
  __isset = other1.__isset;
}
MiniStruct& MiniStruct::operator=(const MiniStruct& other2) {
  my_string = other2.my_string;
  my_enum = other2.my_enum;
  __isset = other2.__isset;
  return *this;
}
void MiniStruct::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "MiniStruct(";
  out << "my_string="; (__isset.my_string ? (out << to_string(my_string)) : (out << "<null>"));
  out << ", " << "my_enum="; (__isset.my_enum ? (out << to_string(my_enum)) : (out << "<null>"));
  out << ")";
}


MegaStruct::~MegaStruct() noexcept {
}


void MegaStruct::__set_my_bool(const bool val) {
  this->my_bool = val;
__isset.my_bool = true;
}

void MegaStruct::__set_my_byte(const int8_t val) {
  this->my_byte = val;
__isset.my_byte = true;
}

void MegaStruct::__set_my_16bit_int(const int16_t val) {
  this->my_16bit_int = val;
__isset.my_16bit_int = true;
}

void MegaStruct::__set_my_32bit_int(const int32_t val) {
  this->my_32bit_int = val;
__isset.my_32bit_int = true;
}

void MegaStruct::__set_my_64bit_int(const int64_t val) {
  this->my_64bit_int = val;
__isset.my_64bit_int = true;
}

void MegaStruct::__set_my_double(const double val) {
  this->my_double = val;
__isset.my_double = true;
}

void MegaStruct::__set_my_string(const std::string& val) {
  this->my_string = val;
__isset.my_string = true;
}

void MegaStruct::__set_my_binary(const std::string& val) {
  this->my_binary = val;
__isset.my_binary = true;
}

void MegaStruct::__set_my_string_string_map(const std::map<std::string, std::string> & val) {
  this->my_string_string_map = val;
__isset.my_string_string_map = true;
}

void MegaStruct::__set_my_string_enum_map(const std::map<std::string, MyEnum::type> & val) {
  this->my_string_enum_map = val;
__isset.my_string_enum_map = true;
}

void MegaStruct::__set_my_enum_string_map(const std::map<MyEnum::type, std::string> & val) {
  this->my_enum_string_map = val;
__isset.my_enum_string_map = true;
}

void MegaStruct::__set_my_enum_struct_map(const std::map<MyEnum::type, MiniStruct> & val) {
  this->my_enum_struct_map = val;
__isset.my_enum_struct_map = true;
}

void MegaStruct::__set_my_enum_stringlist_map(const std::map<MyEnum::type, std::vector<std::string> > & val) {
  this->my_enum_stringlist_map = val;
__isset.my_enum_stringlist_map = true;
}

void MegaStruct::__set_my_enum_structlist_map(const std::map<MyEnum::type, std::vector<MiniStruct> > & val) {
  this->my_enum_structlist_map = val;
__isset.my_enum_structlist_map = true;
}

void MegaStruct::__set_my_stringlist(const std::vector<std::string> & val) {
  this->my_stringlist = val;
__isset.my_stringlist = true;
}

void MegaStruct::__set_my_structlist(const std::vector<MiniStruct> & val) {
  this->my_structlist = val;
__isset.my_structlist = true;
}

void MegaStruct::__set_my_enumlist(const std::vector<MyEnum::type> & val) {
  this->my_enumlist = val;
__isset.my_enumlist = true;
}

void MegaStruct::__set_my_stringset(const std::set<std::string> & val) {
  this->my_stringset = val;
__isset.my_stringset = true;
}

void MegaStruct::__set_my_enumset(const std::set<MyEnum::type> & val) {
  this->my_enumset = val;
__isset.my_enumset = true;
}

void MegaStruct::__set_my_structset(const std::set<MiniStruct> & val) {
  this->my_structset = val;
__isset.my_structset = true;
}
std::ostream& operator<<(std::ostream& out, const MegaStruct& obj)
{
  obj.printTo(out);
  return out;
}


uint32_t MegaStruct::read(::apache::thrift::protocol::TProtocol* iprot) {

  ::apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_BOOL) {
          xfer += iprot->readBool(this->my_bool);
          this->__isset.my_bool = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_BYTE) {
          xfer += iprot->readByte(this->my_byte);
          this->__isset.my_byte = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_I16) {
          xfer += iprot->readI16(this->my_16bit_int);
          this->__isset.my_16bit_int = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->my_32bit_int);
          this->__isset.my_32bit_int = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->my_64bit_int);
          this->__isset.my_64bit_int = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 6:
        if (ftype == ::apache::thrift::protocol::T_DOUBLE) {
          xfer += iprot->readDouble(this->my_double);
          this->__isset.my_double = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 7:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->my_string);
          this->__isset.my_string = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 8:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readBinary(this->my_binary);
          this->__isset.my_binary = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 9:
        if (ftype == ::apache::thrift::protocol::T_MAP) {
          {
            this->my_string_string_map.clear();
            uint32_t _size3;
            ::apache::thrift::protocol::TType _ktype4;
            ::apache::thrift::protocol::TType _vtype5;
            xfer += iprot->readMapBegin(_ktype4, _vtype5, _size3);
            uint32_t _i7;
            for (_i7 = 0; _i7 < _size3; ++_i7)
            {
              std::string _key8;
              xfer += iprot->readString(_key8);
              std::string& _val9 = this->my_string_string_map[_key8];
              xfer += iprot->readString(_val9);
            }
            xfer += iprot->readMapEnd();
          }
          this->__isset.my_string_string_map = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 10:
        if (ftype == ::apache::thrift::protocol::T_MAP) {
          {
            this->my_string_enum_map.clear();
            uint32_t _size10;
            ::apache::thrift::protocol::TType _ktype11;
            ::apache::thrift::protocol::TType _vtype12;
            xfer += iprot->readMapBegin(_ktype11, _vtype12, _size10);
            uint32_t _i14;
            for (_i14 = 0; _i14 < _size10; ++_i14)
            {
              std::string _key15;
              xfer += iprot->readString(_key15);
              MyEnum::type& _val16 = this->my_string_enum_map[_key15];
              int32_t ecast17;
              xfer += iprot->readI32(ecast17);
              _val16 = static_cast<MyEnum::type>(ecast17);
            }
            xfer += iprot->readMapEnd();
          }
          this->__isset.my_string_enum_map = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 11:
        if (ftype == ::apache::thrift::protocol::T_MAP) {
          {
            this->my_enum_string_map.clear();
            uint32_t _size18;
            ::apache::thrift::protocol::TType _ktype19;
            ::apache::thrift::protocol::TType _vtype20;
            xfer += iprot->readMapBegin(_ktype19, _vtype20, _size18);
            uint32_t _i22;
            for (_i22 = 0; _i22 < _size18; ++_i22)
            {
              MyEnum::type _key23;
              int32_t ecast25;
              xfer += iprot->readI32(ecast25);
              _key23 = static_cast<MyEnum::type>(ecast25);
              std::string& _val24 = this->my_enum_string_map[_key23];
              xfer += iprot->readString(_val24);
            }
            xfer += iprot->readMapEnd();
          }
          this->__isset.my_enum_string_map = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 12:
        if (ftype == ::apache::thrift::protocol::T_MAP) {
          {
            this->my_enum_struct_map.clear();
            uint32_t _size26;
            ::apache::thrift::protocol::TType _ktype27;
            ::apache::thrift::protocol::TType _vtype28;
            xfer += iprot->readMapBegin(_ktype27, _vtype28, _size26);
            uint32_t _i30;
            for (_i30 = 0; _i30 < _size26; ++_i30)
            {
              MyEnum::type _key31;
              int32_t ecast33;
              xfer += iprot->readI32(ecast33);
              _key31 = static_cast<MyEnum::type>(ecast33);
              MiniStruct& _val32 = this->my_enum_struct_map[_key31];
              xfer += _val32.read(iprot);
            }
            xfer += iprot->readMapEnd();
          }
          this->__isset.my_enum_struct_map = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 13:
        if (ftype == ::apache::thrift::protocol::T_MAP) {
          {
            this->my_enum_stringlist_map.clear();
            uint32_t _size34;
            ::apache::thrift::protocol::TType _ktype35;
            ::apache::thrift::protocol::TType _vtype36;
            xfer += iprot->readMapBegin(_ktype35, _vtype36, _size34);
            uint32_t _i38;
            for (_i38 = 0; _i38 < _size34; ++_i38)
            {
              MyEnum::type _key39;
              int32_t ecast41;
              xfer += iprot->readI32(ecast41);
              _key39 = static_cast<MyEnum::type>(ecast41);
              std::vector<std::string> & _val40 = this->my_enum_stringlist_map[_key39];
              {
                _val40.clear();
                uint32_t _size42;
                ::apache::thrift::protocol::TType _etype45;
                xfer += iprot->readListBegin(_etype45, _size42);
                _val40.resize(_size42);
                uint32_t _i46;
                for (_i46 = 0; _i46 < _size42; ++_i46)
                {
                  xfer += iprot->readString(_val40[_i46]);
                }
                xfer += iprot->readListEnd();
              }
            }
            xfer += iprot->readMapEnd();
          }
          this->__isset.my_enum_stringlist_map = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 14:
        if (ftype == ::apache::thrift::protocol::T_MAP) {
          {
            this->my_enum_structlist_map.clear();
            uint32_t _size47;
            ::apache::thrift::protocol::TType _ktype48;
            ::apache::thrift::protocol::TType _vtype49;
            xfer += iprot->readMapBegin(_ktype48, _vtype49, _size47);
            uint32_t _i51;
            for (_i51 = 0; _i51 < _size47; ++_i51)
            {
              MyEnum::type _key52;
              int32_t ecast54;
              xfer += iprot->readI32(ecast54);
              _key52 = static_cast<MyEnum::type>(ecast54);
              std::vector<MiniStruct> & _val53 = this->my_enum_structlist_map[_key52];
              {
                _val53.clear();
                uint32_t _size55;
                ::apache::thrift::protocol::TType _etype58;
                xfer += iprot->readListBegin(_etype58, _size55);
                _val53.resize(_size55);
                uint32_t _i59;
                for (_i59 = 0; _i59 < _size55; ++_i59)
                {
                  xfer += _val53[_i59].read(iprot);
                }
                xfer += iprot->readListEnd();
              }
            }
            xfer += iprot->readMapEnd();
          }
          this->__isset.my_enum_structlist_map = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 15:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->my_stringlist.clear();
            uint32_t _size60;
            ::apache::thrift::protocol::TType _etype63;
            xfer += iprot->readListBegin(_etype63, _size60);
            this->my_stringlist.resize(_size60);
            uint32_t _i64;
            for (_i64 = 0; _i64 < _size60; ++_i64)
            {
              xfer += iprot->readString(this->my_stringlist[_i64]);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.my_stringlist = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 16:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->my_structlist.clear();
            uint32_t _size65;
            ::apache::thrift::protocol::TType _etype68;
            xfer += iprot->readListBegin(_etype68, _size65);
            this->my_structlist.resize(_size65);
            uint32_t _i69;
            for (_i69 = 0; _i69 < _size65; ++_i69)
            {
              xfer += this->my_structlist[_i69].read(iprot);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.my_structlist = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 17:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->my_enumlist.clear();
            uint32_t _size70;
            ::apache::thrift::protocol::TType _etype73;
            xfer += iprot->readListBegin(_etype73, _size70);
            this->my_enumlist.resize(_size70);
            uint32_t _i74;
            for (_i74 = 0; _i74 < _size70; ++_i74)
            {
              int32_t ecast75;
              xfer += iprot->readI32(ecast75);
              this->my_enumlist[_i74] = static_cast<MyEnum::type>(ecast75);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.my_enumlist = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 18:
        if (ftype == ::apache::thrift::protocol::T_SET) {
          {
            this->my_stringset.clear();
            uint32_t _size76;
            ::apache::thrift::protocol::TType _etype79;
            xfer += iprot->readSetBegin(_etype79, _size76);
            uint32_t _i80;
            for (_i80 = 0; _i80 < _size76; ++_i80)
            {
              std::string _elem81;
              xfer += iprot->readString(_elem81);
              this->my_stringset.insert(_elem81);
            }
            xfer += iprot->readSetEnd();
          }
          this->__isset.my_stringset = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 19:
        if (ftype == ::apache::thrift::protocol::T_SET) {
          {
            this->my_enumset.clear();
            uint32_t _size82;
            ::apache::thrift::protocol::TType _etype85;
            xfer += iprot->readSetBegin(_etype85, _size82);
            uint32_t _i86;
            for (_i86 = 0; _i86 < _size82; ++_i86)
            {
              MyEnum::type _elem87;
              int32_t ecast88;
              xfer += iprot->readI32(ecast88);
              _elem87 = static_cast<MyEnum::type>(ecast88);
              this->my_enumset.insert(_elem87);
            }
            xfer += iprot->readSetEnd();
          }
          this->__isset.my_enumset = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 20:
        if (ftype == ::apache::thrift::protocol::T_SET) {
          {
            this->my_structset.clear();
            uint32_t _size89;
            ::apache::thrift::protocol::TType _etype92;
            xfer += iprot->readSetBegin(_etype92, _size89);
            uint32_t _i93;
            for (_i93 = 0; _i93 < _size89; ++_i93)
            {
              MiniStruct _elem94;
              xfer += _elem94.read(iprot);
              this->my_structset.insert(_elem94);
            }
            xfer += iprot->readSetEnd();
          }
          this->__isset.my_structset = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t MegaStruct::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  ::apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("MegaStruct");

  if (this->__isset.my_bool) {
    xfer += oprot->writeFieldBegin("my_bool", ::apache::thrift::protocol::T_BOOL, 1);
    xfer += oprot->writeBool(this->my_bool);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_byte) {
    xfer += oprot->writeFieldBegin("my_byte", ::apache::thrift::protocol::T_BYTE, 2);
    xfer += oprot->writeByte(this->my_byte);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_16bit_int) {
    xfer += oprot->writeFieldBegin("my_16bit_int", ::apache::thrift::protocol::T_I16, 3);
    xfer += oprot->writeI16(this->my_16bit_int);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_32bit_int) {
    xfer += oprot->writeFieldBegin("my_32bit_int", ::apache::thrift::protocol::T_I32, 4);
    xfer += oprot->writeI32(this->my_32bit_int);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_64bit_int) {
    xfer += oprot->writeFieldBegin("my_64bit_int", ::apache::thrift::protocol::T_I64, 5);
    xfer += oprot->writeI64(this->my_64bit_int);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_double) {
    xfer += oprot->writeFieldBegin("my_double", ::apache::thrift::protocol::T_DOUBLE, 6);
    xfer += oprot->writeDouble(this->my_double);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_string) {
    xfer += oprot->writeFieldBegin("my_string", ::apache::thrift::protocol::T_STRING, 7);
    xfer += oprot->writeString(this->my_string);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_binary) {
    xfer += oprot->writeFieldBegin("my_binary", ::apache::thrift::protocol::T_STRING, 8);
    xfer += oprot->writeBinary(this->my_binary);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_string_string_map) {
    xfer += oprot->writeFieldBegin("my_string_string_map", ::apache::thrift::protocol::T_MAP, 9);
    {
      xfer += oprot->writeMapBegin(::apache::thrift::protocol::T_STRING, ::apache::thrift::protocol::T_STRING, static_cast<uint32_t>(this->my_string_string_map.size()));
      std::map<std::string, std::string> ::const_iterator _iter95;
      for (_iter95 = this->my_string_string_map.begin(); _iter95 != this->my_string_string_map.end(); ++_iter95)
      {
        xfer += oprot->writeString(_iter95->first);
        xfer += oprot->writeString(_iter95->second);
      }
      xfer += oprot->writeMapEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_string_enum_map) {
    xfer += oprot->writeFieldBegin("my_string_enum_map", ::apache::thrift::protocol::T_MAP, 10);
    {
      xfer += oprot->writeMapBegin(::apache::thrift::protocol::T_STRING, ::apache::thrift::protocol::T_I32, static_cast<uint32_t>(this->my_string_enum_map.size()));
      std::map<std::string, MyEnum::type> ::const_iterator _iter96;
      for (_iter96 = this->my_string_enum_map.begin(); _iter96 != this->my_string_enum_map.end(); ++_iter96)
      {
        xfer += oprot->writeString(_iter96->first);
        xfer += oprot->writeI32(static_cast<int32_t>(_iter96->second));
      }
      xfer += oprot->writeMapEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_enum_string_map) {
    xfer += oprot->writeFieldBegin("my_enum_string_map", ::apache::thrift::protocol::T_MAP, 11);
    {
      xfer += oprot->writeMapBegin(::apache::thrift::protocol::T_I32, ::apache::thrift::protocol::T_STRING, static_cast<uint32_t>(this->my_enum_string_map.size()));
      std::map<MyEnum::type, std::string> ::const_iterator _iter97;
      for (_iter97 = this->my_enum_string_map.begin(); _iter97 != this->my_enum_string_map.end(); ++_iter97)
      {
        xfer += oprot->writeI32(static_cast<int32_t>(_iter97->first));
        xfer += oprot->writeString(_iter97->second);
      }
      xfer += oprot->writeMapEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_enum_struct_map) {
    xfer += oprot->writeFieldBegin("my_enum_struct_map", ::apache::thrift::protocol::T_MAP, 12);
    {
      xfer += oprot->writeMapBegin(::apache::thrift::protocol::T_I32, ::apache::thrift::protocol::T_STRUCT, static_cast<uint32_t>(this->my_enum_struct_map.size()));
      std::map<MyEnum::type, MiniStruct> ::const_iterator _iter98;
      for (_iter98 = this->my_enum_struct_map.begin(); _iter98 != this->my_enum_struct_map.end(); ++_iter98)
      {
        xfer += oprot->writeI32(static_cast<int32_t>(_iter98->first));
        xfer += _iter98->second.write(oprot);
      }
      xfer += oprot->writeMapEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_enum_stringlist_map) {
    xfer += oprot->writeFieldBegin("my_enum_stringlist_map", ::apache::thrift::protocol::T_MAP, 13);
    {
      xfer += oprot->writeMapBegin(::apache::thrift::protocol::T_I32, ::apache::thrift::protocol::T_LIST, static_cast<uint32_t>(this->my_enum_stringlist_map.size()));
      std::map<MyEnum::type, std::vector<std::string> > ::const_iterator _iter99;
      for (_iter99 = this->my_enum_stringlist_map.begin(); _iter99 != this->my_enum_stringlist_map.end(); ++_iter99)
      {
        xfer += oprot->writeI32(static_cast<int32_t>(_iter99->first));
        {
          xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRING, static_cast<uint32_t>(_iter99->second.size()));
          std::vector<std::string> ::const_iterator _iter100;
          for (_iter100 = _iter99->second.begin(); _iter100 != _iter99->second.end(); ++_iter100)
          {
            xfer += oprot->writeString((*_iter100));
          }
          xfer += oprot->writeListEnd();
        }
      }
      xfer += oprot->writeMapEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_enum_structlist_map) {
    xfer += oprot->writeFieldBegin("my_enum_structlist_map", ::apache::thrift::protocol::T_MAP, 14);
    {
      xfer += oprot->writeMapBegin(::apache::thrift::protocol::T_I32, ::apache::thrift::protocol::T_LIST, static_cast<uint32_t>(this->my_enum_structlist_map.size()));
      std::map<MyEnum::type, std::vector<MiniStruct> > ::const_iterator _iter101;
      for (_iter101 = this->my_enum_structlist_map.begin(); _iter101 != this->my_enum_structlist_map.end(); ++_iter101)
      {
        xfer += oprot->writeI32(static_cast<int32_t>(_iter101->first));
        {
          xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRUCT, static_cast<uint32_t>(_iter101->second.size()));
          std::vector<MiniStruct> ::const_iterator _iter102;
          for (_iter102 = _iter101->second.begin(); _iter102 != _iter101->second.end(); ++_iter102)
          {
            xfer += (*_iter102).write(oprot);
          }
          xfer += oprot->writeListEnd();
        }
      }
      xfer += oprot->writeMapEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_stringlist) {
    xfer += oprot->writeFieldBegin("my_stringlist", ::apache::thrift::protocol::T_LIST, 15);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRING, static_cast<uint32_t>(this->my_stringlist.size()));
      std::vector<std::string> ::const_iterator _iter103;
      for (_iter103 = this->my_stringlist.begin(); _iter103 != this->my_stringlist.end(); ++_iter103)
      {
        xfer += oprot->writeString((*_iter103));
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_structlist) {
    xfer += oprot->writeFieldBegin("my_structlist", ::apache::thrift::protocol::T_LIST, 16);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRUCT, static_cast<uint32_t>(this->my_structlist.size()));
      std::vector<MiniStruct> ::const_iterator _iter104;
      for (_iter104 = this->my_structlist.begin(); _iter104 != this->my_structlist.end(); ++_iter104)
      {
        xfer += (*_iter104).write(oprot);
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_enumlist) {
    xfer += oprot->writeFieldBegin("my_enumlist", ::apache::thrift::protocol::T_LIST, 17);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_I32, static_cast<uint32_t>(this->my_enumlist.size()));
      std::vector<MyEnum::type> ::const_iterator _iter105;
      for (_iter105 = this->my_enumlist.begin(); _iter105 != this->my_enumlist.end(); ++_iter105)
      {
        xfer += oprot->writeI32(static_cast<int32_t>((*_iter105)));
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_stringset) {
    xfer += oprot->writeFieldBegin("my_stringset", ::apache::thrift::protocol::T_SET, 18);
    {
      xfer += oprot->writeSetBegin(::apache::thrift::protocol::T_STRING, static_cast<uint32_t>(this->my_stringset.size()));
      std::set<std::string> ::const_iterator _iter106;
      for (_iter106 = this->my_stringset.begin(); _iter106 != this->my_stringset.end(); ++_iter106)
      {
        xfer += oprot->writeString((*_iter106));
      }
      xfer += oprot->writeSetEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_enumset) {
    xfer += oprot->writeFieldBegin("my_enumset", ::apache::thrift::protocol::T_SET, 19);
    {
      xfer += oprot->writeSetBegin(::apache::thrift::protocol::T_I32, static_cast<uint32_t>(this->my_enumset.size()));
      std::set<MyEnum::type> ::const_iterator _iter107;
      for (_iter107 = this->my_enumset.begin(); _iter107 != this->my_enumset.end(); ++_iter107)
      {
        xfer += oprot->writeI32(static_cast<int32_t>((*_iter107)));
      }
      xfer += oprot->writeSetEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.my_structset) {
    xfer += oprot->writeFieldBegin("my_structset", ::apache::thrift::protocol::T_SET, 20);
    {
      xfer += oprot->writeSetBegin(::apache::thrift::protocol::T_STRUCT, static_cast<uint32_t>(this->my_structset.size()));
      std::set<MiniStruct> ::const_iterator _iter108;
      for (_iter108 = this->my_structset.begin(); _iter108 != this->my_structset.end(); ++_iter108)
      {
        xfer += (*_iter108).write(oprot);
      }
      xfer += oprot->writeSetEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(MegaStruct &a, MegaStruct &b) {
  using ::std::swap;
  swap(a.my_bool, b.my_bool);
  swap(a.my_byte, b.my_byte);
  swap(a.my_16bit_int, b.my_16bit_int);
  swap(a.my_32bit_int, b.my_32bit_int);
  swap(a.my_64bit_int, b.my_64bit_int);
  swap(a.my_double, b.my_double);
  swap(a.my_string, b.my_string);
  swap(a.my_binary, b.my_binary);
  swap(a.my_string_string_map, b.my_string_string_map);
  swap(a.my_string_enum_map, b.my_string_enum_map);
  swap(a.my_enum_string_map, b.my_enum_string_map);
  swap(a.my_enum_struct_map, b.my_enum_struct_map);
  swap(a.my_enum_stringlist_map, b.my_enum_stringlist_map);
  swap(a.my_enum_structlist_map, b.my_enum_structlist_map);
  swap(a.my_stringlist, b.my_stringlist);
  swap(a.my_structlist, b.my_structlist);
  swap(a.my_enumlist, b.my_enumlist);
  swap(a.my_stringset, b.my_stringset);
  swap(a.my_enumset, b.my_enumset);
  swap(a.my_structset, b.my_structset);
  swap(a.__isset, b.__isset);
}

MegaStruct::MegaStruct(const MegaStruct& other109) {
  my_bool = other109.my_bool;
  my_byte = other109.my_byte;
  my_16bit_int = other109.my_16bit_int;
  my_32bit_int = other109.my_32bit_int;
  my_64bit_int = other109.my_64bit_int;
  my_double = other109.my_double;
  my_string = other109.my_string;
  my_binary = other109.my_binary;
  my_string_string_map = other109.my_string_string_map;
  my_string_enum_map = other109.my_string_enum_map;
  my_enum_string_map = other109.my_enum_string_map;
  my_enum_struct_map = other109.my_enum_struct_map;
  my_enum_stringlist_map = other109.my_enum_stringlist_map;
  my_enum_structlist_map = other109.my_enum_structlist_map;
  my_stringlist = other109.my_stringlist;
  my_structlist = other109.my_structlist;
  my_enumlist = other109.my_enumlist;
  my_stringset = other109.my_stringset;
  my_enumset = other109.my_enumset;
  my_structset = other109.my_structset;
  __isset = other109.__isset;
}
MegaStruct& MegaStruct::operator=(const MegaStruct& other110) {
  my_bool = other110.my_bool;
  my_byte = other110.my_byte;
  my_16bit_int = other110.my_16bit_int;
  my_32bit_int = other110.my_32bit_int;
  my_64bit_int = other110.my_64bit_int;
  my_double = other110.my_double;
  my_string = other110.my_string;
  my_binary = other110.my_binary;
  my_string_string_map = other110.my_string_string_map;
  my_string_enum_map = other110.my_string_enum_map;
  my_enum_string_map = other110.my_enum_string_map;
  my_enum_struct_map = other110.my_enum_struct_map;
  my_enum_stringlist_map = other110.my_enum_stringlist_map;
  my_enum_structlist_map = other110.my_enum_structlist_map;
  my_stringlist = other110.my_stringlist;
  my_structlist = other110.my_structlist;
  my_enumlist = other110.my_enumlist;
  my_stringset = other110.my_stringset;
  my_enumset = other110.my_enumset;
  my_structset = other110.my_structset;
  __isset = other110.__isset;
  return *this;
}
void MegaStruct::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "MegaStruct(";
  out << "my_bool="; (__isset.my_bool ? (out << to_string(my_bool)) : (out << "<null>"));
  out << ", " << "my_byte="; (__isset.my_byte ? (out << to_string(my_byte)) : (out << "<null>"));
  out << ", " << "my_16bit_int="; (__isset.my_16bit_int ? (out << to_string(my_16bit_int)) : (out << "<null>"));
  out << ", " << "my_32bit_int="; (__isset.my_32bit_int ? (out << to_string(my_32bit_int)) : (out << "<null>"));
  out << ", " << "my_64bit_int="; (__isset.my_64bit_int ? (out << to_string(my_64bit_int)) : (out << "<null>"));
  out << ", " << "my_double="; (__isset.my_double ? (out << to_string(my_double)) : (out << "<null>"));
  out << ", " << "my_string="; (__isset.my_string ? (out << to_string(my_string)) : (out << "<null>"));
  out << ", " << "my_binary="; (__isset.my_binary ? (out << to_string(my_binary)) : (out << "<null>"));
  out << ", " << "my_string_string_map="; (__isset.my_string_string_map ? (out << to_string(my_string_string_map)) : (out << "<null>"));
  out << ", " << "my_string_enum_map="; (__isset.my_string_enum_map ? (out << to_string(my_string_enum_map)) : (out << "<null>"));
  out << ", " << "my_enum_string_map="; (__isset.my_enum_string_map ? (out << to_string(my_enum_string_map)) : (out << "<null>"));
  out << ", " << "my_enum_struct_map="; (__isset.my_enum_struct_map ? (out << to_string(my_enum_struct_map)) : (out << "<null>"));
  out << ", " << "my_enum_stringlist_map="; (__isset.my_enum_stringlist_map ? (out << to_string(my_enum_stringlist_map)) : (out << "<null>"));
  out << ", " << "my_enum_structlist_map="; (__isset.my_enum_structlist_map ? (out << to_string(my_enum_structlist_map)) : (out << "<null>"));
  out << ", " << "my_stringlist="; (__isset.my_stringlist ? (out << to_string(my_stringlist)) : (out << "<null>"));
  out << ", " << "my_structlist="; (__isset.my_structlist ? (out << to_string(my_structlist)) : (out << "<null>"));
  out << ", " << "my_enumlist="; (__isset.my_enumlist ? (out << to_string(my_enumlist)) : (out << "<null>"));
  out << ", " << "my_stringset="; (__isset.my_stringset ? (out << to_string(my_stringset)) : (out << "<null>"));
  out << ", " << "my_enumset="; (__isset.my_enumset ? (out << to_string(my_enumset)) : (out << "<null>"));
  out << ", " << "my_structset="; (__isset.my_structset ? (out << to_string(my_structset)) : (out << "<null>"));
  out << ")";
}


