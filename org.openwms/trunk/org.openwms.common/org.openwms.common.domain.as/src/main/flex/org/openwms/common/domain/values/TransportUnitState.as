/**
 * Generated by Gas3 v2.0.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR.
 */

package org.openwms.common.domain.values {

    import org.granite.util.Enum;

    [Bindable]
    [RemoteClass(alias="org.openwms.common.domain.values.TransportUnitState")]
    public class TransportUnitState extends Enum {

        public static const AVAILABLE:TransportUnitState = new TransportUnitState("AVAILABLE", _);
        public static const OK:TransportUnitState = new TransportUnitState("OK", _);
        public static const NOT_OK:TransportUnitState = new TransportUnitState("NOT_OK", _);

        function TransportUnitState(value:String = null, restrictor:* = null) {
            super((value || AVAILABLE.name), restrictor);
        }

        override protected function getConstants():Array {
            return constants;
        }

        public static function get constants():Array {
            return [AVAILABLE, OK, NOT_OK];
        }

        public static function valueOf(name:String):TransportUnitState {
            return TransportUnitState(AVAILABLE.constantOf(name));
        }
    }
}