# Copyright (C) 2020 Mirza Krak

FILESEXTRAPATHS:prepend:coral-dev := "${THISDIR}/${PN}:"

SUMMARY:coral-dev = "Linux Kernel provided and supported by Google for Coral Dev Board"

SRCBRANCH:coral-dev = "release-day"
SRCREV:coral-dev = "f19426310e2e0ff490a3160a64a05018d7f6c536"

SRC_URI:coral-dev = "\
    git://coral.googlesource.com/linux-imx;protocol=https;branch=${SRCBRANCH} \
    file://defconfig \
    file://0001-compiler-attributes-add-support-for-copy-gcc-9.patch \
    file://0002-include-linux-module.h-copy-init-exit-attrs-to-.patch \
"

# As we use the 'defconfig' from Mendel OS (Debian) build scripts, we must also
# replicate the configure step to merge it.
do_configure:coral-dev() {
    oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} defconfig
    cat "${WORKDIR}/defconfig" | tee -a "${B}/.config"
    oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig
}
